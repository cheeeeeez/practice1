console.log("js시작");
const fileDelete = document.querySelector("#fileDelete"); //앞의 fileDelete:변수명
fileDelete.addEventListener("click", function(event){
    
    console.log("fileDelete클릭"); //클릭했다고 콘솔창에 표시해줌 (console log자체가 확인하는 용도, sysout이랑 비슷한 용도)
   // alert("정말 삭제하시겠습니까?");
    let check = window.confirm("정말 삭제하시겠습니까?");
    if(!check) {
        return;
    }
    console.log(event.target);  //이걸로 클릭할 때 이벤트 타겟을 보여줌.
    //let fileNum = 
    let fileNum = event.target.getAttribute("data-num");
    let fileName = event.target.getAttribute("data-name");


    $.ajax({
        type: "POST",
        url: "./fileDelete",
        data: {
            fileNum: fileNum,
            fileName: fileName
        },
        success: function(data) {
            if (data.trim() == '1') {
                /*select.parent().remove();
                v1Count--; */
            } else {
                alert("파일 삭제 실패");
            }
        },
        error: function() {
            alert("파일 삭제 실패")
        }
    });

} )
