jQuery(document).ready(function () {
alert('testing');
        jQuery("#grid").jqGrid({
            height: 250,
            url: 'http://localhost:8080/billapp/rest/api/prices/list',
            mtype: "GET",
            contentType: "application/json; charset=utf-8",
            datatype: "json",
            serializeGridData: function (postData) {
                return JSON.stringify(postData);
            },
            jsonReader: {
                root: function (obj) { return obj; },
                page: function (obj) { return 1; },
                total: function (obj) { return 1; },
                records: function (obj) { return obj.length; },
                id: "0",
                cell: "",
                repeatitems: false
            },
            datatype: "json",
            colNames: ['Id', 'Itemname', 'Customer', 'Price'],
                colModel: [
                    { name: 'priceId', index:'priceId', width:55,editable:false},
                    { name: 'itemName', width: 130, sortable: false },
                    { name: 'customerName', width: 100, sortable: false },
                    { name: 'unitPrice', width: 180, sortable: false }
                ],
                
            gridview: true,
            autoencode: true,
            ignorecase: true,
            loadonce: true,
            sortname: "InstallmentDate",
            sortorder: "asc",
            viewrecords: true,
            rowNum: 10,
            rowList: [10, 15, 20],
            pager: '#pager',
            caption: "Price list"
        });

         $("#grid").jqGrid('navGrid', '#pager',
            {
                add: true,
                edit: true,
                del: true
            },
            editOption,
            addOption,
            delOption);

        var editOption =
            {
                width: 400, height: 290, left: 20, top: 30,
                reloadAfterSubmit: false, jqModal: false, editCaption: "Edit Record",
                bSubmit: "Submit", bCancel: "Cancel", closeAfterEdit: true,
                mtype: "POST",
                url: 'http://localhost:8080/billapp/rest/api/prices/edit'
            };

        var addOption = {
            width: 400, height: 290, left: 20, top: 30,
            reloadAfterSubmit: false, jqModal: false, addCaption: "Add Record",
            bSubmit: "Submit", bCancel: "Cancel",
            closeAfterAdd: true,
            mtype: "PUT",
            url: 'http://localhost:8080/billapp/rest/api/prices/create'
        };

        var delOption = {
            caption: "Delete",
            msg: "Delete selected record(s)?",
            bSubmit: "Delete", bCancel: "Cancel",
            mtype: "DELETE",
            url: 'http://localhost:8080/billapp/rest/api/prices/delete'
        };

    });