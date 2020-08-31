// var thongbao = {}  || thongbao;
// thongbao.intTable = function(){
//     $("#layoutSidenav_content").DataTable({
//         ajax: {
//             url: 'http://localhost:8080/adminJS/thongbaoJS',
//             method: "GET",
//             datatype: "json",
//             dataSrc: ""
//         },
//         columns: [
//             { data: "noiDung" , name: "noiDung", title: "Noi dung",orderable: true},
//             { data: "ngayTao", name : "ngayTao" , title: "Ngay tao"},
//             { data: "id", name : "Action", title : "Action",sortable: false,
//                 orderable: false ,"render": function ( data, type, row, meta ) {
//
//                     var str =  "<a href='javascript:;' title='edit thongBao' onclick='thongbao.get("+ data +")'><i class='fa fa-edit'></i></a> " +
//                         "<a href='javascript:;' title='remove thongBao' onclick='thongbao.delete("+ data +")' ><i class='fa fa-trash'></i></a>"
//                     return str ;
//                 }
//             }
//         ]
//     });
// }
var thongbao = thongbao || {} ;
thongbao.showTitle = function (){
    $.ajax(
        {
            url: 'http://localhost:8080/adminJS/thongbao/text' ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
                console.log(data);
                let t = $('#dataTable').DataTable({
                    responsive: true
                });
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function( index, value ) {
                    t.row.add( [
                        value.tieuDe,
                        value.noiDung,
                        "<i class='far fa-edit ' style='margin-right: 10px'></i>" +
                        "<i class='far fa-trash-alt '></i>"
                        ,
                    ]).draw();
                });


            },
            error: function (e) {
                console.log(e.message);
            }
        })
}

$(document).ready(function(){
    thongbao.showTitle();
});