  $(function () {
            'use strict';
            var URL = "http://localhost:8080/billapp/rest/api";
            $("#grid").jqGrid({
                url: "http://localhost:8080/billapp/rest/api/prices/list",
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
                
                colNames: ['Id', 'Itemname', 'Customer', 'Price'],
                colModel: [
                    { name: 'priceId', id:'Id',width: 100,editoptions:{readonly:true,size:10}, sortable: true, sorttype: "int" },
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
                    { name: 'customerName', width: 100, sortable: false ,edittype:"select",
                      editoptions:{
                		dataUrl: 'http://localhost:8080/billapp/rest/api/customer/list',
               			buildSelect: function (data) {
               	         var response = jQuery.parseJSON(data);
                         if (response!= null && response.length) {
                            var strOutput = '<select>';
                 			$.each(response, function(key, val) {
                 				strOutput += '<option value="' + val.custid + '">' + val.custName + '</option>';
  							});
  				  		 }
  
  				  		 return strOutput + "</select>";
               		    }//function
               		  }//editoption
                    },
                    { name: 'unitPrice', width: 180, sortable: false }
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
                caption: "Price Details"
            });
            
            $.extend($.jgrid.edit, {
				closeAfterEdit: true,
				closeAfterEdit: true,
				reloadAfterSubmit:true,
				width:350,
				ajaxEditOptions: { contentType: "application/json" },
				serializeEditData: function(data) {
				//alert('data>>>>>><<<<<<<' +JSON.stringify(data));
				data.custId=data.customerName,
    			data.itemId=data.itemName
				    if(data.oper =='add')
				    {
				       delete data.id;
				    }
				    else{
				        data.id=data.priceId;
				    }
				    delete data.customerName;
				    delete data.itemName;
				    delete data.priceId;
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
    		  	//alert("Post data " +JSON.stringify(postdata));
				params.url = params.url + '/' + rowData.priceId;
			},
		    serializeDelData: function(data) {
				return "";
			}
		});
			
	$("#grid").jqGrid('navGrid', '#pager', { edit: true, add: true, del: true },
    //edit options
    { url: 'http://localhost:8080/billapp/rest/api/price/edit',mtype: 'POST' },
    //add options
    { url: 'http://localhost:8080/billapp/rest/api/price/create',mtype: 'POST' },
    //delete options
    { url: 'http://localhost:8080/billapp/rest/api/price/delete' }
	);
 });
