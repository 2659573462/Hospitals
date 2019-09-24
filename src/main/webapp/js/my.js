(function ($) {
    window.my = function () {
        var html = '<div class="modal fade" tabindex="-1" id="[Id]" role="dialog">\n' +
            '    <div class="modal-dialog" role="document">\n' +
            '        <div class="modal-content">\n' +
            '            <div class="modal-header">\n' +
            '                <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
            '                    <span aria-hidden="true">&times;</span>\n' +
            '                </button>\n' +
            '                <h4 class="modal-title">[Title]</h4>\n' +
            '            </div>\n' +
            '            <div class="modal-body">\n' +
            '                <p>[Message]</p>\n' +
            '            </div>\n' +
            '            <div class="modal-footer">\n' +
            '                <button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>\n' +
            '                <button type="button" class="btn btn-info ok" data-dismiss="modal">[BtnOk]</button>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>\n' +
            '</div>';
        var dialogHtml = '<div class="modal fade" tabindex="-1" id="[Id]" role="dialog">\n' +
            '    <div class="modal-dialog" role="document">\n' +
            '        <div class="modal-content">\n' +
            '            <div class="modal-header">\n' +
            '                <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
            '                    <span aria-hidden="true">&times;</span>\n' +
            '                </button>\n' +
            '                <h4 class="modal-title">[Title]</h4>\n' +
            '            </div>\n' +
            '            <div class="modal-body"></div>\n' +
            '        </div>\n' +
            '    </div>\n' +
            '</div>';
        var reg = new RegExp('\\[([^\\[\\]]*?)\\]','igm');
        // 获取ID
        var generateId = function () {
            var date = new Date();
            return 'mdl' + date.valueOf();
        }
        // 初始化
        var init = function (options) {
            options = $.extend({},{
                title:'操作提示',
                message:'提示内容',
                btnok:'确定',
                btncl:'取消',
                width:200,
                auto:false
            },options || {});
            // ID
            var modalId = generateId();
            // 弹框正文
            var content = html.replace(reg,function (node,key) {
                return {
                    Id:modalId,
                    Title: options.title,
                    Message:options.message,
                    BtnOk:options.btnok,
                    BtnCancel:options.btncl
                }[key];
            })
            // 把弹框追加到body中
            $('body').append(content);
            // 初始化弹框大小
            $('#'+modalId).modal({
                width:options.width,
                backdrop:'static'
            })
            // 监听弹框的关闭事件
            $("#"+modalId).on('hide.bs.modal',function(e){
                $("body").find('#'+modalId).remove();
            })
            return modalId;
        }
        return {
            alert: function (options){
                if (typeof options === 'string'){
                    options = {
                        message:options
                    };
                }
                var id = init(options);
                var modal = $("#"+id);
                // 移除样式
                modal.find('.ok').removeClass('btn-success').add('btn-info');
                // 隐藏取消按钮
                modal.find('.cancel').hide();
                return {
                    id:id,
                    on:function(callback) {
                        if (callback && callback instanceof Function){
                            modal.find('.ok').click(function(){
                                callback(true);
                            });
                        }
                    },
                    hide:function(callback){
                        if (callback && callback instanceof Function){
                            modal.on('hide.bs.modal',function(e){
                                callback(e);
                            })
                        }
                    }
                };
            },
            confirm:function(options){
                var id = init(options);
                var modal = $('#'+id);
                modal.find('.ok').removeClass('btn-info').add('btn-success');
                modal.find('.cancel').show();
                return {
                    id:id,
                    on:function(callback){
                        if (callback && callback instanceof Function){
                            modal.find('.ok').click(function(){
                                callback(true);
                            });
                            modal.find('.cancel').click(function(){
                                callback(false);
                            })
                        }
                    },
                    hide:function(callback){
                        if (callback && callback instanceof Function){
                            modal.on('hide.bs.modal',function(e){
                                callback(e);
                            })
                        }
                    }
                };
            },
            dialog:function(options){
                options = $.extend({},{
                    title: 'title',
                    url:'',
                    width:800,
                    height:500,
                    onReady:function(){},
                    onShow:function(e){}
                },options || {});
                var modalId = generateId();
                var content = dialogHtml.replace(reg,function(node,key){
                    return {
                        Id: modalId,
                        Title:options.title
                    }
                });
                $('body').append(content);
                var target = $('#'+modalId);
                target.find('.modal-body').load(options.url);
                if (options.onReady()){
                    options.onReady.call(target);
                }
                // 打开弹框
                target.modal();
                target.on('shown.bs.modal',function(e){
                    if (options.onReady(e)){
                        options.onReady.call(target,e);
                    }
                });
                target.on('hide.bs.modal',function(e){
                    $('body').find(target).remove();
                })
            }
        }
    }();
})(jQuery);