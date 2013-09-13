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
		
ハンズオン３(5分)
	DOM操作のテストとスパイ機能を確認してみよう

ハンズオン４(10分)

ハンズオン５(10分)
