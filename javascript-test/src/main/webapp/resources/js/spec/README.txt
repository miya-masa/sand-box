ハンズオン１(10分)
	JasmineのAssert機能を確認してみよう！
		【必須要件】
			１．describe"jasmineのassert機能の内、"内の最低１つのitを完成させること
			２．一つのitの中で一つのアサート関数を検証すること
			３．下に示すアサート関数は上から順に検証すること
			４．最低１回は"not"を使って検証する事
		【推奨要件】
			１．振る舞いを意識し、describeとitに名前をつける。
		【基本文法】
				expect(実測値).【not】.検証するアサート関数(【理論値】)
		【検証するアサート関数】
			toBe(expect)・・・"==="での比較であることに注意
			toEqual(expect)・・・オブジェクトの比較
			toMatch(expect)・・・正規表現で比較
			toBeNull()・・・null判定
			toThrow()・・・関数オブジェクトが例外をスローするかを検証
			toBeDefined()、toBeUndefined()・・・定義されているかどうかを検証
			toContain(expect)・・・配列にexpectが含まれているかを検証
			toBeLessThan()、toBeGreaterThan()・・・数値の大小比較
			toBeFalsy()、toBeTruthy()・・・キャストした時にtrueになるかどうかを判定
			toBeClose(expect,number)・・・数値をまるめて比較する。
			
ハンズオン２(5分)
	JasmineのbeforeEachとafterEachの動作を確認してみよう
		【必須要件】
			１．test.jsのdesription"テスト前後をフックする関数、"の中身を記述して、完成させること
			fooとbarを利用しても良いです。必要なければ消してしまっても構いません。
		【ヒント】
			※必要ない人は以下は読まなくてもいいですよ！
			
			foo、barはdescribeで定義されているテスト関数内で参照できます。
			テストは上から順番に実行されるので、
			beforeEachでfooとbarを1ずつ追加し、
			afterEachでfooを0にクリアする。
			beforeEachとafterEachが期待通りに動作する場合、
			それぞれのテストでfooとbarはどんな値になるでしょう？
			expectを利用して検証してみよう！

ハンズオン３(15分)
	スパイ機能を確認してみよう！
		【手順】
			'jasmine、spy機能で、'内のitを完成させる。同describe内で共通スコープspyTarget
			があるのでこのオブジェクトをスパイして実装を進める。
			
		【ヒント】
			spyに対して
			toHaveBeenCalledWith(param)...引数paramで呼び出されたかどうかを検証
			spyOn().andCallFake(匿名関数)、spyOn().andCallThrough()
			JavaScriptの時計をスパイする方法
				jasmine.Clock.useMock()で時計をモック化
				setInterval(callback,millseconds);
				jsmine.Clock.tick(milliseconds)で時計をmilliseconds分進める
		
ハンズオン４(15分)
	DOM操作のテストとスパイ機能を確認してみよう
	ハンズオン４－１ DOMテスト
		【実装:beforEeachと'DOMを取得する'の実装】
			１．<div id="loaded-fixture">Hello World!!</div>をDOMに追加
			２．さらに<ul id="append">を追加
			３．id=loaded-fixtureを取得してテキストとIDを検証する
				(toHaveId()とtoHaveText()を使う)
				
			【ヒント】
				DOM設定ははsetFixtures(html);
				setFixtures(html)後にhtmlを追加する場合は
				appendSetFixtures(html)
				追加要素が<div>の場合は
				sandbox()を使うと簡単
				sandbox({
					id : "id"
				})は<div id="id">と同義
				とすると簡単。
			
		【実装:beforeEachと'イベントを発火して追加されたDOM要素を確認する。'の実装】
			１．DOMをセットしたあとにsample-controllerを初期化
			２．id=append要素のクリックイベント発火
			３．子要素が増えていることを確認
			
			【ヒント】
				クリックイベント発火はjqueryオブジェクト.click()
				子要素取得はjqueryオブジェクト.children('条件')
				条件はjqueryのページから調べてみよう！
				
			
	ハンズオン４－２DOMとスパイテスト
		【手順】
			１．DOMをセットしたあとにsample-controllerを初期化(恐らく実装済み)
			２．console.logをスパイ
			３．loaded-fixtureのクリックイベントを発火
			４．console.logが引数'Clicked'で呼び出されたことを確認する。
			
			ヒント
				spyOn(obj,'関数名')でobjが保持する関数'関数名'をスパイオブジェクトに
				変換できる。
				jqueryオブジェクトに対して引数なしclick()とするとイベント発火
				expect('スパイオブジェクト').toHaveBeenCalledWith('期待値')でスパイ

ハンズオン5(10分)
	TDDを体験しよう！
	【準備】
		１．srcディレクトリ以下にhandson.jsを作成
		２．specディレクトリ以下にtest-handson.jsを作成
		３．karma起動
	【手順】
		１．名前を引数に”Hello {名前}!!”と返すコードを作成しよう！
		２．オブジェクトでもプロトタイプでもどちらでもOK
		３．関数名等も自由
		４．TDDで開発するため、必ずtest-handson.jsから記述し、
			失敗することを確認してからhandson.jsを作成すること！

		終わったら、自分なりに工夫していろいろなテスト書いても良いです。
		自分の名前を入れたら特別な文字列返すとか
		時間によって返り値が変わるとか(spy機能を使おう！)
		
