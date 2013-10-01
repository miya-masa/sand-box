describe('Jasmineのassert機能の内,', function() {
	// TODO 【ハンズオン1 Assert機能】
});

describe('テスト前後をフックする関数、', function() {
	'use strict';
	// TODO 【ハンズオン2 beforeEachとafterEachの動作確認】
	var foo = 0;
	var bar = 0;

	beforeEach(function() {
		// TODO
	});

	afterEach(function() {
		// TODO
	});

	it('beforeEach()は各テストの前に実行する。', function() {
		// TODO
	});

	it('afterEachは各テストの後に実行する。', function() {
		// TODO
	});
});

describe('jasmine、spy機能は、', function() {

	/**
	 * @type SpyTarget
	 */
	var spyTarget = null;

	beforeEach(function() {
		var SpyTarget = function() {
			this.value = 0;
		};
		SpyTarget.prototype = {
			value : 0,
			setValue : function(value) {
				this.value = value;
			},
			getValue : function() {
				return this.value;
			}
		};
		spyTarget = new SpyTarget();
	});
	it('spyされたsetValueを実行し、toHaveBeenCalledWith()で呼び出しを確認する。', function() {
		// TODO
	});
	it('spyされたsetValueを実行しても、オリジナルは呼び出されない事を確認する。', function() {
		// TODO
	});
	it('getValueをスパイし、andCallThrough()でオリジナルも呼び出す事を確認確認する。', function() {
		// TODO
	});
	it('getValueをスパイし、andCallFake()で関数を書き換える事を確認する。', function() {
		// TODO
	});
	it('JavaScriptの時計をスパイしsetIntervalを確認する。', function() {
		// TODO
	});
});

// ここではsample.controllerを利用する
describe('jasmin-jqueryを使って、', function() {
	'use strict';
	// 対象要素
	var $target = null;

	beforeEach(function() {
		// TODO 【ハンズオン3 DOMテスト】
	});
	it('DOMを取得する。', function() {
		// TODO 【ハンズオン3 DOMテスト】
		// ヒント toHaveId()、toHaveText()
		expect($target).toBe('div');
	});

	it('イベントを発火して追加されたDOM要素を確認する。', function() {
		// TODO 【ハンズオン3 DOMテスト】
	});
	it('イベントを発火する。', function() {
		// TODO 【ハンズオン3 DOMとスパイテスト】
	});
	// デバッグの練習用。このテストが失敗する利用をデバッガを利用して調べてみよう！
	// もしわかったらどうすれば良いか考えてみよう。
	xit('DOMを追加する。', function() {
		$('<div id="inner">').css('background-color', 'red').text(
				'I am inner!!').appendTo($target);
		var $inner = $target.find('#inner');
		expect($inner).toBe('div');
		expect($inner).toHaveCss({
			'background-color' : 'red'
		});
	});

});
