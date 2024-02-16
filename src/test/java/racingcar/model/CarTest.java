package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Nested
    class ValidateInput {
        @Test
        @DisplayName("이름이 5자 초과 시 예외 발생")
        void testNameUnderFive() {
            String given = "문자열이일곱자";
            assertThatThrownBy(() -> new Car(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Feature {
        @Test
        @DisplayName("차 1칸 이동")
        void testMove() {
            Car car = new Car("차");
            car.move();
            int actual = car.getPosition();
            int expected = 1;
            assertThat(actual).isEqualTo(expected);
        }
    }
}
