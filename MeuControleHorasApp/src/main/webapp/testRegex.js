

//console.log(/^[a-zA-Z]+( [a-zA-Z]+)*$/.test("sdfsdf dfasfd h hh"));

//console.log(/[^a-zA-Z ]+/g.test("**"));

//console.log(/\s{2,}/g.test("jjjdjd zdfasdfasdf  "));

var v = " endeu&& jdhfh999  hdjdjjd     sdasdasd ";
console.log(v);

var re = /\s{2,}/g;
var re2 = /^\s|\s$|/g;
var re3 = /[^a-zA-Z ]+/g;

v = v.replace(re, " ");
v = v.replace(re2, "");
v = v.replace(re3, "");
console.log(v);








var regex = /^[a-zA-Z]+( [a-zA-Z]+)*$/;
if(!regex.test(ctrl.$viewValue)) {
    ctrl.$setViewValue(ctrl.$viewValue);
    ctrl.$render();
}
