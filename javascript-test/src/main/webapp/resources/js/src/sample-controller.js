var sample = {};// 名前空間
/**
 * サンプルコントローラ.<br>
 */
sample.contoller = {
	/**
	 * 初期化関数.<br>
	 * 要素にイベントをバインドする.
	 */
	init : function() {
		// idがloaded-fixtureにハンドラをバインド
		$('#loaded-fixture').click(this['#loaded-fixture click']);
		// idがappendにハンドラをバインド
		$('#append').click(this['#append click']);
	},
	/**
	 * idがloaded-fixtureの要素がクリックされた時のイベントハンドラ.<br>
	 * コンソールに'Clicked'と出力する.
	 */
	'#loaded-fixture click' : function() {
		console.log('Clicked');
	},
	/**
	 * idがappendの要素がクリックされた時のイベントハンドラ.<br>
	 * append要素に
	 * 
	 * <pre>
	 * 	<li>
	 * appended
	 * <li>
	 * </pre>
	 * 
	 * を追加する.
	 */
	'#append click' : function() {
		$('<li>').text('appended').appendTo($(this));
	}
};
// 初期化コード
$(function() {
	sample.contoller.init();
});