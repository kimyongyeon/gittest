/* using arguments */
var range = Rx.Observable.range(0, 5);

var source = Observable.zip(
	range,
	range.skip(1),
	range.skip(2),
	function (s1, s2, s3) {
		return s1 + ":" + s2 + ":" + s3;
	}
);

var subscription = source.subscribe(
	function(x) {
		console.log('Next: ' + x);
	},
	function(err) {
		console.log('Error: ' + err);
	},
	function() {
		console.log('Completed');
	}
)