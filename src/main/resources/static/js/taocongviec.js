var taocongviec = taocongviec || {}
taocongviec.phongban = function (){
    $.ajax(
        {
            url: 'http://localhost:8080/api/phongban/view' ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
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

taocongviec.nhanvien = function (element){
    let idPhongBan= $(element).val();
    $.ajax(
        {
            url: 'http://localhost:8080/api/nhanvien/view/'+idPhongBan ,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data){
                $('#nhanVienId').html("<option disabled selected>--/--</option>");
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

$(document).ready(function () {
    taocongviec.phongban();
    // taocongviec.nhanvien();
});