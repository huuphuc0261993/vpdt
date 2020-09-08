var taocongviec = taocongviec || {}

// var phongBanList;
var nhanVienLamViec = []
taocongviec.listphongban = function () {
    $.ajax(
        {
            url: 'http://localhost:8080/api/phongban/view',
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                // phongBanList = data;
                $('#phongBanId').html("<option disabled selected>--/--</option>");
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function (index, value) {
                    $('#phongBanId').append(
                        "<option value='" + value.mpb + "' >" + value.tenPB + "</option>"
                    );
                });
            },
            error: function (e) {
                console.log(e.message);
            }
        })
}
var nhanVienList;
taocongviec.phongban = function (element) {
    let idPhongBan = $(element).val();
    $.ajax(
        {
            url: 'http://localhost:8080/api/nhanvien/view/' + idPhongBan,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                $('#nhanVienId').html("");
                // nhanVienList = data;
                // index chỉ mục mảng , value giá trị của phần tử mảng
                $.each(data, function (index, value) {
                    if (nhanVienLamViec.indexOf(value.mnv) == -1) {
                        $('#nhanVienId').append(
                            "<option value='" + value.mnv + "'>" + value.fullName + "</option>"
                        );
                    }

                });
            },
            error: function (e) {
                console.log(e.message);
            }
        })
}
var inNhavien=[];
taocongviec.showNhanVien = function (){
    taocongviec.phongban($('#phongBanId'));
    let t = $('#dataTable').DataTable();
    t.clear().draw();
    $.each(inNhavien, function (index, value) {
        console.log(index + ","+value);
        t.row.add([
            value[1],
            value[2],
            `<input type='radio' name='iMain' value='${value[0]}'>`,
            `<span onclick='taocongviec.xoa(${index})'><i class='far fa-trash-alt' ></i></span>`
        ]).draw();

    });
}
//kiểm tra
// document.querySelectorAll("input[name='iMain']")[0].checked
taocongviec.them = function () {
    let idPhongBan = $('#phongBanId').val();
    let phongban = $('#phongBanId').find(`option[value='${idPhongBan}']`).text();
    let idNhanVien = $('#nhanVienId').val();
    let nhanvien = $('#nhanVienId').find(`option[value='${idNhanVien}']`).text();

    if (nhanvien == "") {
        alert("Thêm không thành công")
    } else {
        nhanVienLamViec.push(+idNhanVien);
        inNhavien.push([+idNhanVien,phongban,nhanvien]);

        taocongviec.showNhanVien();

    }

    // $.ajax(
    //     {
    //         url: 'http://localhost:8080/api/nhanvien/' + idPhongBan + '/' + idNhanVien,
    //         method: 'GET',
    //         dataType: 'json',
    //         contentType: 'application/json',
    //         success: function (data) {
    //             let t = $('#dataTable').DataTable();
    //             // index chỉ mục mảng , value giá trị của phần tử mảng
    //             $.each(data, function (index, value) {
    //                 t.row.add([
    //                     value.phongBan.tenPB,
    //                     value.fullName,
    //                     "<input type='checkbox'>",
    //                     "<i class='far fa-trash-alt' onclick='taocongviec.xoa()'></i>"
    //                 ]).draw();
    //
    //             });
    //         },
    //         error: function (e) {
    //             console.log(e.message);
    //         }
    //     })
}

taocongviec.xoa = function (index) {
    bootbox.confirm({
        title: "Xóa Thông Báo",
        message: "Bạn có muốn xóa ko?",
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> No'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Yes'
            }
        }   ,
        callback: function (result) {
            if(result){
                nhanVienLamViec.splice(index,1);
                inNhavien.splice(index,1);
                taocongviec.showNhanVien();
            }
        }
    });

}

$(document).ready(function () {

    taocongviec.listphongban();


    // taocongviec.nhanvien();
});