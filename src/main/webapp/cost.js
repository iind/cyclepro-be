  $(function () {
            'use strict';
            var URL = "http://localhost:8080/billapp/rest/api";
            $("#grid").jqGrid({
                url: "http://localhost:8080/billapp/rest/api/cost/list",
                datatype: "json",
                height: "auto",
                jsonReader: {
                    root: function (obj) {
                        return obj;
                    },
                    repeatitems: false
                },
                serializeGridData: function (postData) {
                    return JSON.stringify(postData);
                },
                
                colNames: ['Id', 'Itemname', 'Contractor', 'Unit Cost'],
                colModel: [
                    { name: 'costId', id:'Id',width: 100,editoptions:{readonly:true,size:10}, sortable: true, sorttype: "int" },
                    { name: 'itemName', id:'itemId',width: 200, sortable: false ,edittype:"select",
                    editoptions:{
                		dataUrl: 'http://localhost:8080/billapp/rest/api/item/list',
               			buildSelect: function (data) {
               	         var response = jQuery.parseJSON(data);
                         if (response!= null && response.length) {
                            var strOutput = '<select>';
                 			$.each(response, function(key, val) {
                 				strOutput += '<option value="' + val.itemId + '">' + val.itemName + '</option>';
  							});
  				  		 }
 
  				  		 return strOutput + "</select>";
               		    }//function
               		  }//editoption
                    },
                    
                    //http://localhost:8080/billapp/rest/api/customer/list
                    { name: 'contractorName', width: 100, sortable: false ,edittype:"select",
                    
                      editoptions:{
                		dataUrl: 'http://localhost:8080/billapp/rest/api/contractor/list',
               			buildSelect: function (data) {
               	         var response = jQuery.parseJSON(data);
                         if (response!= null && response.length) {
                            var strOutput = '<select>';
                 			$.each(response, function(key, val) {
                 				strOutput += '<option value="' + val.contractorId + '">' + val.emailId + '</option>';
  							});
  				  		 }
  
  				  		 return strOutput + "</select>";
               		    }//function
               		  }//editoption
                    },
                    { name: 'unitCost', width: 180, sortable: false }
                ],
               
				cmTemplate: {editable: true},
                rowNum: 10,
                rowList: [10, 30, 1000],
                loadonce: true,
                rownumbers: true,
                gridview: true,
                pager: "#pager",
				ignoreCase: true,
                sortname: 'invdate',
                viewrecords: true,
                sortorder: "desc",
                caption: "Cost Details"
            });
            
            $.extend($.jgrid.edit, {
				closeAfterEdit: true,
				closeAfterEdit: true,
				reloadAfterSubmit:true,
				width:350,
				ajaxEditOptions: { contentType: "application/json" },
				serializeEditData: function(data) {
			    //alert('data>>>>>><<<<<<<' +JSON.stringify(data));
				data.contractorId=data.contractorName,
    			data.itemId=data.itemName
    			
				    if(data.oper =='add')
				    {
				       delete data.costId;
				    }
				    else{
				  			delete data.id;
					}
				     delete data.id;
				    delete data.contractorName;
				    delete data.itemName;
				    //delete data.priceId;
				    delete data.oper;
					//alert('after remove final data>>>>>><<<<<<<' +JSON.stringify(data));
					return JSON.stringify(data);
				},
				
				afterSubmit:function(response,postdata)
				{
					$("#grid").jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
					return "";
				}
			});
			
			$.extend($.jgrid.del, {
				mtype: 'DELETE',
				ajaxEditOptions: { contentType: "application/json" },
				onclickSubmit: function(params, postdata) {
				var selRowId = $('#grid').jqGrid('getGridParam','selrow');
				var rowData = $('#grid').jqGrid("getRowData", selRowId);
    		  	//alert("Post data " +JSON.stringify(rowData));
				params.url = params.url + '/' + rowData.costId;
			},
		    serializeDelData: function(data) {
				return "";
			}
		});
			
	$("#grid").jqGrid('navGrid', '#pager', { edit: true, add: true, del: true },
    //edit options
    { url: 'http://localhost:8080/billapp/rest/api/cost/edit',mtype: 'POST' },
    //add options
    { url: 'http://localhost:8080/billapp/rest/api/cost/create',mtype: 'POST' },
    //delete options
    { url: 'http://localhost:8080/billapp/rest/api/cost/delete' }
	);
 });
