# Sentinel-Backend

Backend presetting

spring boot 3.0.6버전 <br>
java 17<br>
intellij
<br>

<h2> 기능구현 </h2>
development 기준으로 기능별로 branch를 따서 작업 후 <br> branch - development에 머지하는 식으로 진행

<br>
---------

<h4>build.gradle에 의존성 추가 해놨습니다.</h4>
<h4>기존 목록</h4>
dependencies { <br>
	&nbsp;&nbsp;implementation 'org.springframework.boot:spring-boot-starter-web' <br>
	&nbsp;&nbsp;testImplementation 'org.springframework.boot:spring-boot-starter-test' <br>
 }
  
<h4>추가 후 목록 </h4>
dependencies { <br>
&nbsp;&nbsp;	implementation 'org.springframework.boot:spring-boot-starter-web' <br>
&nbsp;&nbsp;	testImplementation 'org.springframework.boot:spring-boot-starter-test' <br>
<br>
&nbsp;&nbsp;	implementation 'org.springframework.boot:spring-boot-starter-data-jpa' <br>
&nbsp;&nbsp;	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client' <br>
&nbsp;&nbsp;	compileOnly 'org.projectlombok:lombok' <br>
&nbsp;&nbsp;	annotationProcessor 'org.projectlombok:lombok'<br>
}
