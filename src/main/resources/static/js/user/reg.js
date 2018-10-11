layui.use('form', function(){
    var form = layui.form;
    form.verify({
        affirmPassword: function(value,item){
            //原始密码
            var password = $('#L_pass').val();
            console.log(value == password);
            if(!value == password){
                return '两次密码不正确';
            }
        }
    });

    //监听提交
    form.on('submit(regFilter)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });

});