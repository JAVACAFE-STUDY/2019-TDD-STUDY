객체지향 생활체조
Object Calisthenics
==

###### written by 자바카페 금성현

---
<!-- footer:Object Calisthenics. -->

Nine Steps 
to Better Software Design Today
==
- 객체지향 어렵!
	- Good object-oriented design can be hard to learn;  
	- Many developers assume they’re
doing a good job with OO design, when in reality they’re unconsciously stuck in procedural habits that are hard to break. 

- 좋은 (객체지향) 디지인
	- cohesion, loose coupling, zero duplication, encapsulation, testability,
readability, and focus. 

---
The Rules
Here are the rules for the exercise:
==
1. Use only one level of indentation per method.
2. Don’t use the else keyword.
3. Wrap all primitives and strings.
4. Use only one dot per line.
5. Don’t abbreviate.
6. Keep all entities small.
7. Don’t use any classes with more than two instance variables.
8. Use first-class collections.
9. Don’t use any getters/setters/properties.

---

객체지향 생활 체조
==

규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
규칙 2: else 예약어를 쓰지 않는다.
규칙 3: 모든 원시값과 문자열을 포장한다.
규칙 4: 한 줄에 점을 하나만 찍는다.
규칙 5: 줄여쓰지 않는다(축약 금지).
규칙 6: 모든 엔티티를 작게 유지한다.
규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
규칙 8: 일급 콜렉션을 쓴다.
규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

---

단계적 연습
==
### 1단계. 메소드(함수)를 분리하는 연습
	- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
	- 규칙 2: else 예약어를 쓰지 않는다.

### 2단계. 객체를 분리하는 연습
	- 규칙 3: 모든 원시값과 문자열을 포장한다.
	- 규칙 6: 모든 엔티티를 작게 유지한다.
	- 규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
	- 규칙 8: 일급 콜렉션을 쓴다.
	
### 마지막 단계. 깔끔한 코드(clean code)
	- 규칙 4: 한 줄에 점을 하나만 찍는다.
	- 규칙 5: 줄여쓰지 않는다(축약 금지).
	- 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

---
규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
===
- **각 메서드가 정확히 한 가지 일을 하는지**, 
- 즉, 메서드당 하나의 제어 구조나 하나의 문장 단락(block)으로 되어 있는지를 지키려고 노력
- 애플리케이션의 각 단위가 더 작아짐에 따라 재사용의 수준은 기하급수적으로 상승하기 시작한다.

---
before
```java
class Board {
   ...
   String board() {
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++)
            buf.append(data[i][j]);
         buf.append("\n");
      }
      return buf.toString();
   }
}
 
```
---
after
```java
class Board {
   ...
   String board() {
      StringBuffer buf = new StringBuffer();
      collectRows(buf);
      return buf.toString();
   }
 
   void collectRows(StringBuffer buf) {
      for (int i = 0; i < 10; i++)
         collectRow(buf, i);
   }
 
   void collectRow(StringBuffer buf, int row) {
      for (int i = 0; i < 10; i++)
         buf.append(data[row][i]);
      buf.append("\n");
   }
}
```

---
규칙 2: else 예약어 금지
===
- 조건문는 코드 중복의 원흉이기도 하다 
---
before
```java
public static void endMe() {
   if (status == DONE) {
      doSomething();
   } else {
      // 다른 코드
   }
}
 
```
after
```java
public static void endMe() {
   if (status == DONE) {
      doSomething();
      return ;
   }
   // 다른 코드
}
```

---

- 간단한 경우라면 보호절(guard clause)과 조기 반환(early return)으로 대체 가능하다.

before

```java
double getPayAmount() {     
	double result;      
  	if (_isDead) result = deadAmount();      
  	else {      
    	if (_isSeparated) result = separatedAmount();      
    	else {      
            if (_isRetired) result = retiredAmount();      
            else result = normalPayAmount();      
        };      
    }      
    return result;      
}
```

---

after
```java
double getPayAmount() {     
    if (_isDead) return deadAmount();      
    if (_isSeparated) return separatedAmount();      
    if (_isRetired) return retiredAmount();      
    return normalPayAmount();      
};  
```

---
- 다형성 사용
before
```java
public void barkAnimal(Animal animal) {
    if (animal instanceof Tiger) {
        System.out.println("어흥");
    } else if (animal instanceof Lion) {
        System.out.println("으르렁");
    }
}
```
---
after
```java
public interface Barkable {
    public void bark();
}

public class Tiger extends Animal {
    public void bark() {
        System.out.println("어흥");
    }
}

public void barkAnimal(Barkable animal) {
    animal.bark();
}
```
---
규칙 3. 원시값과 문자열의 포장
===
```
예를 들어, int형의 원시값을 파라미터로 가지는 메서드가 있다고 가정할 때, 
int형에 시간 데이터가 입력될지, 날짜 데이터가 입력되는지를 알기 위해선 
변수명 혹은 주석등을 통해 의도가 명확하게 개발자가 작성해야 한다.
```
- 변수들을 객체화하여 재사용성을 높이고, 
- 변수의 의미를 명확하게 표현을 할 수 있기때문에 지향
	- 실수 방지 

- 단, 재사용성이 적은 것들까지 객체화하여 사용하는것은 오히려 코드의 가독성을 저해하고, 관리하기 힘들게 할 수 있음.

---
규칙 4. 한 줄에 한 점만 사용
===

- 여러 개의 점이 들어 있는 코드 몇 줄을 들여다보기 시작하면 책임 소재의 오류를 많이 발견하기 시작한다.
- 그 모든 점들이 연결돼 있다면 대상 객체는 다른 객체에 깊숙이 관여하고 있는 셈

---
before

```java
class Board {
   ...
 
   class Piece {
      ...
      String representation;
   }
   class Location {
      ...
      Piece current;
   }
 
   String boardRepresentation() {
      StringBuffer buf = new StringBuffer();
      for (Location l : squares())
         buf.append(l.current.representation.substring(0, 1));
      return buf.toString();
   }
}
 
```
---
after
```java
class Board {
   class Piece {
      private String representation;
      String character() {
         return representation.substring(0, 1);
      }
      void addTo(StringBuffer buf) {
         buf.append(character());
      }
   }
   class Location {
      private Piece current;
 
      void addTo(StringBuffer buf) {
         current.addTo(buf);
      }
   }
   String boardRepresentation() {
      StringBuffer buf = new StringBuffer();
      for (Location l : squares())
         l.addTo(buf);
      return buf.toString();
   }
}
```
---
규칙 5. 축약 금지
===

- 누구나 실은 클래스, 메서드, 또는 변수의 이름을 줄이려는 유혹에 곧잘 빠지곤 한다. 그런 유혹을 뿌리쳐라.
	- 축약은 혼란을 야기하며, 더 큰 문제를 숨기는 경향이 있다.

- 클래스 이름이 Order라면 shipOrder라고 메서드 이름을 지을 필요가 없다. 
	- 짧게 ship()이라고 하면 클라이언트에서는 order.ship()라고 호출하며, 간결한 호출의 표현이 된다.

---

규칙 6: 모든 엔티티를 작게 유지한다.
===
- 50줄 이상 되는 클래스와 10개 파일 이상 되는 패키지는 없어야 한다. 보통 50줄 이상의 클래스는 한 가지 이상의 일을 하는 것이며 코드의 이해와 재사용을 점점 더 어렵게 끌고 간다. 
- 클래스를 작게 작성할 때 난관은 같이 있어야 말이 되는 동작의 묶음이 종종 있는 경우이다. 
- 패키지도 클래스처럼 응집력 있고 단일한 목표가 있어야 한다. 패키지를 작게 유지함으로써 패키지 자체로 진정한 정체성을 지니기에 이른다.

---

규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
===
```java
class Name {
    String first;
    String middle;
    String last;
}
```
새로운 인스턴스 변수를 하나 더 기존 클래스에 추가하면 클래스의 응집도는 즉시 떨어진다. 일반적으로 많은 인스턴스 변수를 지닌 클래스를 대상으로 응집력 있는 단일 작업을 설명할 수 있는 경우는 거의 없다. 위 코드는 다음과 같이 세 클래스로 분해할 수 있다.

---
```java
class Name {
    Surname family;
    GivenNames given;
}

class Surname {
    // 성(family name)의 판별은 다른 이름 요소와 근본적으로 다르다.
    String family;
}

class GivenNames {
    // first name, middle name 등 그 밖의 이름을 흡수할 수 있다.
    List<String> names;
}
```
속성의 집합에서 오브젝트를 협력 오브젝트의 계층 구조로 분해하면 더 직접적으로 효율적인 오브젝트 모델에 이른다.


---

규칙 8: 일급 콜렉션을 쓴다.
===
콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다. 
- 각 콜렉션은 그 자체로 포장 되어 있으므로 이제 콜렉션과 관련된 동작의 근거지가 마련된 셈이다. 
- 필터 같은 메소드가 이 새 클래스의 일부가 됨을 알 수 있다.

규칙3과 같은 원리이다. 
- 또한 일반적인 콜렉션은 범용적으로 사용되기 위해 다양한 메소드들을 제공 하는데 클래스로 감싸면서(Wrap) 외부에 노출할 메소드를 조절할 수 있다.

---
before
```java
Map<String, String> map = new HashMap<>();
map.put("1", "A");
map.put("2", "B");
map.put("3", "C");
```
after
```java
public class GameRanking {

    private Map<String, String> ranks;

    public GameRanking(Map<String, String> ranks) {
        this.ranks = ranks;
    }
}
```


---
규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.
===

- 세터를 사용하지 않으면 객체가 생성된 후 임의로 값이 변하는 것을 방지할 수 있다. 외부에서 임의로 객체 내부의 값을 변경하지 않고 그 책임을 객체가 지도록 한다.
- 클라이언트에서 게터를 통해 값을 가져와 처리를 하려고 하지 말고 그냥 그 객체에 책임을 넘기도록 한다.
- Don't ask! Just Tell !!!