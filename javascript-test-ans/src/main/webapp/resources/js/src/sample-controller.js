var sample = {};// 名前空間
sample.contoller = {
	init : function() {
		$('#loaded-fixture').click(this['#loaded-fixture click']);
		$('#append').click(this['#append click']);
	},
	'#loaded-fixture click' : function() {
		console.log('Clicked');
	},
	'#append click' : function() {
		$('<li>').text('appended').appendTo($(this));
	}
};
$(function() {
	sample.contoller.init();
});