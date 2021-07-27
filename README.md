
# API : 
https://github.com/minyul/kotlin_api/tree/main/src/main/kotlin/com/example/minyul/test/api
# DTO : 
https://github.com/minyul/kotlin_api/tree/main/src/main/kotlin/com/example/minyul/test/dto

#Validation :
사용하는 이유 
: 유효성 검증하는 코드의 길이가 너무 길다.
: service login에 대해서 방해가 된다.
: 흩어져 있는 경우 어디서 검증 되었는지 찾기 힘들다.
: 검증 로직이 변경되는 경우 테스트 코드 등 전체로직이 흔들린다.