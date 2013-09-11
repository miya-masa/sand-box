describe('Jasmineのassert機能の内,', function() {
	it('toBe()は"==="で比較する。', function() {
		expect(true).toBe(true);
		expect(true).not.toBe(false);
		expect(true).not.toBe('true');
	});
	it('toEqual()はオブジェクトの内容を比較する。', function() {
		var expectObj = {
			a : 12,
			b : 34
		};
		var actualObj = {
			a : 12,
			b : 34
		};
		var notEqualObj = {
			a : 123,
			b : 34,
		};
		expect(actualObj).toEqual(expectObj);
		expect(actualObj).not.toEqual(notEqualObj);
	});
	it('toMatch()は正規表現で文字列を比較する。', function() {
		var message = 'Hello World!!';
		expect(message).toMatch('Hello');
		expect(message).toMatch('^Hello .*');
		expect(message).not.toMatch('^Hello$');
	});
	it('toBeNull()はnull判定をする。', function() {
		expect(null).toBeNull();
		expect({}).not.toBeNull();
	});

	it('toThrow()は関数オブジェクトが例外をスローするかを確認する。', function() {
		var throwError = function() {
			throw new Error();
		};
		var notThrowError = function() {
		};
		expect(throwError).toThrow();
		expect(notThrowError).not.toThrow();
	});

	it('toBeDefined()は変数が定義されているかどうかを確認する。', function() {
		var foo = {
			defined : 'defeined'
		};
		expect(foo.defined).toBeDefined();
		expect(undefined).not.toBeDefined();
		expect(foo.undef).not.toBeDefined();
	});

	it('toBeUndefined()は変数が"undefined"かどうかを確認する。', function() {
		var foo = {
			defined : 'defeined'
		};
		expect(foo.defined).not.toBeUndefined();
		expect(undefined).toBeUndefined();
		expect(foo.undef).toBeUndefined();
	});

	it('toContain()は配列の中に要素が含まれているかを確認する。', function() {
		var foo = [ 'a', 'b', 'c' ];
		var bar = [ {
			'a' : 1
		}, {
			'b' : 2
		}, {
			'c' : 3
		} ];
		expect(foo).toContain('a');
		expect(foo).toContain('b');
		expect(foo).not.toContain('d');
		expect(bar).toContain({
			'a' : 1
		});
		expect(bar).toContain({
			'b' : 2
		});
		expect(bar).not.toContain({
			'd' : 4
		});
	});

	it('toBeLessThan()は数値が小さいかどうかを確認する。', function() {
		expect(1).toBeLessThan(10);
		expect(1).not.toBeLessThan(0);
	});
	it('toBeGreaterThan()は数値が大きいかどうかを確認する。', function() {
		expect(1).not.toBeGreaterThan(10);
		expect(1).toBeGreaterThan(0);
	});
	it('toBeFalsy()はキャストした時にfalseであることを確認する。', function() {
		expect(null).toBeFalsy();
		expect(0).toBeFalsy();
		expect({}).not.toBeFalsy();
	});
	it('toBeTruthy()はキャストした時にtrueであることを確認する。', function() {
		expect(null).not.toBeTruthy();
		expect(0).not.toBeTruthy();
		expect({}).toBeTruthy();
	});
	it('toBeClose()は指定した小数点以下を丸めた状態で数値を比較する', function() {
		// 小数第二位で比較(小数第三位を四捨五入)1.23と1.23
		expect(1.234567).toBeCloseTo(1.23123, 2);
		// 小数第三位で比較(小数第四位を四捨五入)1.234と1.231
		expect(1.234567).not.toBeCloseTo(1.23123, 3);
	});
});
describe('テスト前後をフックする関数、', function() {

	var foo = 0;

	beforeEach(function() {
		foo += 1;
	});

	afterEach(function() {
		foo = 0;
	});

	it('beforeEach()は各テストの前に実行する。', function() {
		foo++;
		expect(foo).toBe(2);
	});

	it('afterEachは各テストの後に実行する。', function() {
		expect(foo).toBe(1);
	});
});

describe('jasmin-jqueryを使って、', function() {

	var $target = null;

	beforeEach(function() {
		setFixtures('<div id="loaded-fixture">Hello World!!</div>');
		$target = $('#loaded-fixture');
	});
	it('DOMを取得する', function() {
		expect($target).toBe('div');
		expect($target).toHaveId('loaded-fixture');
		expect($target).toHaveText('Hello World!!');
	});

	it('DOMを追加する', function() {
		$('<div id="inner">').css('background-color', 'red').text('I am inner!!').appendTo($target);
		var $inner = $target.find('#inner');
		expect($inner).toBe('div');
		expect($inner).toHaveCssCustom({
			'background-color' : 'red'
		});
		expect($('<div id="inner">').css('background-color', 'red')).toHaveCssCustom({
			'background-color' : 'red'
		});
	});
});
beforeEach(function() {
	this.addMatchers({
		toHaveCssCustom : function(expected) {
			for ( var prop in expected) {
				if (this.actual[0].style[prop] !== expected[prop])
					return false;
			}
			return true;
		}
	});
});
