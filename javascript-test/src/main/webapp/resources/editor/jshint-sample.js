var a = atob("dGVzdA=="), b = btoa("test");

// DOMParser
var dp = new DOMParser();
var dom = dp.parseFromString("<test>jshint</test>", "text/xml");

// XMLSerializer
var xs = new XMLSerializer();
var dom_str = xs.serializeToString(dom);

// node
var filterAccept = NodeFilter.FILTER_ACCEPT;
var elementNode = Node.ELEMENT_NODE;

// MutationObserver
var mutationObserver = new MutationObserver(/* callback */);

// SVGElement
var svgProto = SVGElement.prototype;
(function() {
	if (a == b)
		return;

	if (a != b)
		return;

	if (a == null) // This should fail even when eqeqeq is true
		return;
}());
var a = function() {
	return;
}();

var b = (function() {
	return;
})();

var c = (function() {
	return;
}());

var d = (function() {
	return;
});

var e = (function(a) {
	return;
}).call(null, 1);

var f = (function() {
	return;
}).apply(null, []);

var g = (function() {
	return;
}.apply(null, []));

var h = (function() {
	return;
}.call(null, true, undefined));