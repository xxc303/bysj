function post() {
    var parentId = $("#teacher_id").val();
    var item = $("#item").val();
    var content = $("#comment_content").val();
    var overview = $("#overview").val();
    $.ajax({
        type:"post",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "parentId":parentId,
            "item":item,
            "content":content,
            "overview":overview
        }),
        success:function (response) {
            console.log(response);
            if(response.code == 200){
                window.location.reload();
            }else if (response.code == 500){
                alert("请先登录！")
            }
        },
        dataType:"json"
    });
    console.log(parentId);
}
