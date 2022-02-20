import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTests {

    private static Stream<Arguments> nameVariants() {
        return Stream.of(
                Arguments.of("Тимоти Шаламе", true),
                Arguments.of("ТимотиШаламе Тимоти", true),
                Arguments.of("Т а", true),
                Arguments.of("ТимотиШаламе", false),
                Arguments.of("ТимотиШаламе ТимотиШ", false),
                Arguments.of("Тимо  тиШаламе", false),
                Arguments.of(" ", false),
                Arguments.of(" Тимоти Шаламе", false),
                Arguments.of("Тимоти Шаламе ", false),
                Arguments.of(null , false)

        );
    }

    @ParameterizedTest
    @MethodSource("nameVariants")
    @Feature("Контроль корректности именования банковской карты")
    @DisplayName("Проверка имени")
    public void checkCardHolderNameTest(String name, Boolean status) {
        Account account = new Account(name);
        assertEquals(status, account.checkNameToEmboss(), "Некорректный результат программы");
    }

}