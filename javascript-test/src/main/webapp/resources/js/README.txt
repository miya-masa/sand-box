準備
　１．サーバを起動しhttp://localhost:8080/javascript-test-ans/resources/js/SpecRunner.htmlへChromeでアクセス
　２．SpecRunner.htmlのDOCTYPE宣言をHTML5に変更する。(<!DOCTYPE html>に変更)
　３．SpecRunner.htmlのエンコーディングをUTF-8に変更する。(<meta charset="UTF-8">をヘッダータグに挿入)
　５．spec/test.jsをSpecRunner.htmlにインクルードする
　６．SpecRunner.htmlがブラウザ上で正常に動作することを確認後、デフォルトファイルのインクルード設定を削除(ファイルは残す)
　７．SpecRunner.htmlを開いているブラウザを更新し、画面が表示されれば完了