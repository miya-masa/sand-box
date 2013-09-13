describe("Jasmineのassert機能の内,", function() {
	// TODO
});

describe("テスト前後をフックする関数、", function() {

	var foo = 0;
	var bar = 0;

	beforeEach(function() {
		// TODO
	});

	afterEach(function() {
		// TODO
	});

	it("beforeEach()は各テストの前に実行する。", function() {
		// TODO
	});

	it("afterEachは各テストの後に実行する。", function() {
		// TODO
	});
});
// ここではsample.controllerを利用する
describe('jasmin-jqueryを使って、', function() {

	var $target = null;

	beforeEach(function() {
		// TODO 以下のコードの前に、
		// <div id="loaded-fixture">Hello World!!</div>
		// をsetFixtures(html)を使ってDOMに追加。
		// appendSetFixturesを使って<ul id = append>を追加する
		// sample.controllerを初期化する
		$target = $('#loaded-fixture');
	});
	it('DOMを取得する。', function() {
		// TODO 以下に続けてloaded-fixtureがロードされたこと、loaded-fixtureのテキストがHello
		// Worldであることを確認する
		// ヒント toHaveId()、toHaveText()
		expect($target).toBe('div');
	});
	// デバッグの練習用。このテストが失敗する利用をデバッガを利用して調べてみよう！
	xit('DOMを追加する。', function() {
		$('<div id="inner">').css('background-color', 'red').text(
				'I am inner!!').appendTo($target);
		var $inner = $target.find('#inner');
		expect($inner).toBe('div');
		expect($inner).toHaveCss({
			'background-color' : 'red'
		});
	});

	it('イベントを発火する。', function() {
		// TODO
		// テストはスパイ機能を利用してテストを行う
		// console.logをスパイする
		// loaded-fixtureのクリックイベントを発火
		// console.logが引数'Clicked'で呼び出されたことを確認する。
		//
		// ヒント toHaveBeenCalledWith(param)でスパイオブジェクトが
		// 引数paramで呼び出したかどうかを検証する
	});

	it('イベントを発火して追加されたDOM要素を確認する。', function() {
		// TODO
		// #appendを取得しクリックイベントを発火
		// 子要素の数が1になっていることを確認し、子要素のテキストが"appended"であることも確認する。
		// 再度クリックイベントを発火し、子要素の数が2に増えてることを確認しテキストも確認する。
		//
		// ヒント:子要素のはjqueryオブジェクトに対してchildren('条件')で取得できる。
		// 引数に条件を指定できるのだが、条件については調べてみよう！

	});
});
