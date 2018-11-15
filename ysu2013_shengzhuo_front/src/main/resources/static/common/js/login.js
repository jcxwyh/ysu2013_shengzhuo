/**
 * @author  AaronJiang
 * @date    2018/05/03
 * @mail    1327994105@qq.com
 * @description login
 * @version 1.0
 */

$(function(){

    $(".go-btn").on("click",function(){
        // $(this).css({
        //     backgroundColor:"rgba(255,106,106,1)",
        //     border:"1px solid rgba(255,106,106,1)",
        //     boxShadow:"0 0 6px 7px rgba(255,106,106,0.5)"
        // })

        var name = $(".go-input").val();
        if(name){
            swal({
                title:"班级通告",
                text:"这是要密码的",
                icon:"info",
                content:{
                    element:"input",
                    attributes:{
                        placeholder:"",
                        type:"password"
                    }
                },
                button:{
                    text:"进班",
                },
                closeOnClickOutside:false,
                closeOnEsc:true,
                animation:"slide-from-top"
            });
        }else{
            swal({
                title:"班级通告",
                text:"别忘了你的大名",
                icon:"warning",
                button:{
                    text:"好的",
                    value:true,
                    visible:true,
                    className:"",
                    closeModal:true
                }
            })
        }

    })


    // //背景轮换
    // var i = 1;
    // setInterval(function(){
    //     if(i>2){
    //         i=1;
    //     }
    //     var img = "../static/image/loginbg/"+i+".jpg";
    //     $(".background-image").animate({
    //         background:"url("+img+") no-repeat center fixed",
    //         backgroundSize:"cover"
    //     },300);
    //     i++;
    // },2000);

    //控制音乐
    $(".control-audio-btn").on("click",function(){
        var $audio = $("#bg-audio").get(0);
        if($audio.paused){
            $audio.play();
            $("#audio-icon").css({color:"rgba(54,54,54,1)"});
        } else{
            $audio.pause();
            $("#audio-icon").css({color:"rgba(0,255,255,0.8)"});
        }
        $("#audio-icon").toggleClass("icon-zanting");
        $("#audio-icon").toggleClass("icon-bofang");
    });
})
