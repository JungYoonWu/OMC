/**
 * OMC관련 함수 모음
 */
/// Form과 관련된 공백체크
let checkBlank = function (tag, msg){
	if(tag.value == ''){
		alert(msg)
		tag.focus()
		return true
	}
	return false
}