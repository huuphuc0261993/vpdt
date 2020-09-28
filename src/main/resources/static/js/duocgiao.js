var duocgiao = duocgiao || {}
duocgiao.listcongviec = function () {
    $.ajax(
        {
            url: urlPathHost+'/api/duocgiao/view',
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                let t = $('#dataTable').DataTable({
                    responsive: true
                });
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function (index, value) {
                    t.row.add([
                        value.tieuDe,
                        value.noiDung,
                        "<i class='far fa-edit ' title='Chỉnh sửa thông báo' style='margin-right: 10px' onclick='thongbao.edit(" + value.id + ")'></i>" +
                        "<i class='far fa-trash-alt ' onclick='thongbao.delete(" + value.id + ")'></i>"
                        ,
                    ]).draw();
                });


            },
            error: function (e) {
                console.log(e.message);
            }
        })
}
$(document).ready(function () {
    taocongviec.listphongban();
});