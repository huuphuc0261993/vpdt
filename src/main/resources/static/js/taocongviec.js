var taocongviec = taocongviec || {}
var phongBanList;
var nhanVienLamViec = []
taocongviec.listphongban = function (){
    $.ajax(
        {
            url: 'http://localhost:8080/api/phongban/view' ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
                // phongBanList = data;
                $('#phongBanId').html("<option disabled selected>--/--</option>");
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function( index, value ) {
                    $('#phongBanId').append(
                        "<option value='" + value.mpb + "' >"  + value.tenPB + "</option>"
                    );
                });
            },
            error: function (e) {
                console.log(e.message);
            }
        })
}
var nhanVienList;
taocongviec.phongban = function (element){
    let idPhongBan= $(element).val();
    $.ajax(
        {
            url: 'http://localhost:8080/api/nhanvien/view/'+idPhongBan ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
                $('#nhanVienId').html("");
                // nhanVienList = data;
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function( index, value ) {
                    $('#nhanVienId').append(
                        "<option value='" + value.mnv + "'>" + value.fullName + "</option>"
                    );
                });
            },
            error: function (e) {
                console.log(e.message);
            }
        })
}

taocongviec.them = function (){
    let idPhongBan = $('#phongBanId').val();
    let idNhanVien = $('#nhanVienId').val();

    $.ajax(
        {
            url: 'http://localhost:8080/api/nhanvien/'+idPhongBan+'/'+idNhanVien ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
                console.log(data);
                let t = $('#tBody').DataTable({
                    responsive: true
                });
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function( index, value ) {
                    t.row.add( [
                        value.tenPB,
                        value.fullName,
                        "<input type='checkbox' class='far fa-trash-alt '>",
                        "<i class='far fa-edit ' title='Chỉnh sửa thông báo' style='margin-right: 10px' onclick='thongbao.edit("+value.id+")'></i>" +
                        "<i class='far fa-trash-alt ' onclick='thongbao.delete("+ value.id +")'></i>"
                        ,
                    ]).draw();
                });


            },
            error: function (e) {
                console.log(e.message);
            }
        })
   // let nhanVien= nhanVienList[$('#nhanVienId').val()];
   // console.log(nhanVien);
   // let phongBan = phongBanList[$('#phongBanId').val()];
   // console.log(phongBan);
   //  let viecLam = {
   //      tenPhongBan : phongBan.tenPB,
   //      tenNhanVien: nhanVien.fullName
   //  }
   //  nhanVienLamViec.push(viecLam);
   //  console.log(nhanVienLamViec);

}
$(document).ready(function () {
    taocongviec.listphongban();
    // taocongviec.nhanvien();
});