
var App = {
	Models : {},
	Routers : {},
	Collections : {},
	Views : {}
};

App.Models.Team = Backbone.Model.extend({
	defaults : {
		name : ""
	},
	
	initialize : function() {
		this.bind("change", this.changed);
	},
	
	validate : function(attributes){
		if (!!attributes && attributes.name === "teamX") {
			return "Error!";
		}
	},
	
	changed : function() {
		console.log("changed");
	}
});

App.Collections.Teams = Backbone.Collection.extend({
    model : App.Models.Team
});

App.Views.Teams = Backbone.View.extend({
	el : 'ul.team-list'
});

App.Views.Team = Backbone.View.extend({
	className : '.team-element',
	tagName : 'div',
	model : new App.Models.Team(),
	
	initialize : function() {
		this.model.bind('change', this.render, this);
	},

	render : function() {
		// Compile the template
		var compiledTemplate = _.template($('#teamTemplate').html());

		//$(this.el).html("<span>" + this.model.get("name") + "</span>");
		$(this.el).html(compiledTemplate(this.model.toJSON()));
	},
	events : {
		'click a.more' : 'moreInfo'
	},
	
	moreInfo : function(e){
		// Logic here
	}

});


App.Routers.Main = Backbone.Router.extend({

	// Hash maps for routes
	routes : {
		"": "index",
		"/teams" : "getTeams",
		"/teams/:country" : "getTeamsCountry",
		"/teams/:country/:name" : "getTeam",
		"*error" : "fourOfour"
	},

	index: function(){
		// Homepage 
		var team1 = new App.Models.Team({
			name : "name1"
		});
		console.log(team1.get("name")); // prints "name1"

		// "name" attribute is set with a new value
		team1.set({
			name : "name2"
		});
		console.log(team1.get("name")); 

		var teams = new App.Collections.Teams();
		
		teams.add(team1);
		teams.add(new App.Models.Team({
			name : "Team B"
		}));
		teams.add(new App.Models.Team());
		teams.remove(team1);

		console.log(teams.length);
	},

	getTeams: function() {
		// List all teams 
	},
	getTeamsCountry: function(country) {
		// Get list of teams for specific country
	},
	getTeam: function(country, name) {
		// Get the teams for a specific country and with a specific name
	},	
	fourOfour: function(error) {
		// 404 page
	}
});



$(function(){
    var router = new App.Routers.Main();
    Backbone.history.start({pushState : true});
});

/*
var tback = function(){
	
	function init() {
		bindEvents();
	}
	
	function bindEvents() {
		var contral = $("#contral");
		contral.on("click","#addBtn",function(){
			var username = $.trim(contral.find("[name='username']").val());
			var password = $.trim(contral.find("[name='password']").val());
			if("" == username || "" == password) {
				alert("Please input full information!");
				return;
			}
			$("#table").append("<p>"+username+"--"+password+"</p>");
		});
	}
	
	return {
		init:function(){init();}
	};
}();
$(function(){
	// tback.init();
});
*/