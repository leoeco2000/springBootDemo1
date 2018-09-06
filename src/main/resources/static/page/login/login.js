$(document).ready(function() { // 注释一
	// 定义User
	var User = Backbone.Model.extend({});

	// 定义UserList，是User的集合
	var UserList = Backbone.Collection.extend({
		model : User,
		url : "/account/list", // 注释二
        /*****重载fetch****
        fetch : function() {
            var self = this;
            $.ajax({
                url: self.url,
                cache:false,
                type: 'GET',
                async: true,
                dataType: 'json',
                timeout: 300000,
                success: function( data, textStatus ) {
                    self.reset(data.user);
                },
            });
        }
        *************/
	});

	// 定义UserItemView，用来显示用户列表中的一个条目
	var UserItemView = Backbone.View.extend({
		tagName : "li",
//		userItemTemplate : _.template($("#user-item-template").html()), // 绑定模板
		events : {
//			"click .update_id": "updateMoney"
		},
		render : function() {
//			this.$el.html(this.userItemTemplate(this.model.toJSON()));
			return this;
		},
		transitionTo: function(screenName, option) {
			var cmconst = {};
			cmconst.ROOT_PATH = "/account/";
			if(option && option.isNewWindow) {
				window.open(cmconst.ROOT_PATH + screenName);
			} else {
				location.href = cmconst.ROOT_PATH + screenName;
			}
		},
		updateMoney: function(e){
			var defer = $.Deferred();
			var id = e.target.id;
//			this.transitionTo('update/'+id);
			$.ajax({
				type: 'GET',
				url: '/account/update/'+ id
			})
			.done(function(data){
				$("#right").text(data);
				return defer.resolve(data).promise();
			});
		}
	});

});