package io.study.gosgjung.javabasicexamplecode.utilities;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ApacheCommonsTest {

    @Test
    public void TEST_COMMONS_LANG3_String_Empty_Blank_체크(){
        // 빈문자, 공백문자, null 문자 체크
        String emptyString = "";
        String blankString = "     ";
        String nullString = null;

        // isEmpty
        assertThat(StringUtils.isEmpty(emptyString)).isTrue();
        assertThat(StringUtils.isEmpty(nullString)).isTrue();
        assertThat(StringUtils.isEmpty(blankString)).isFalse();

        // isBlank
        assertThat(StringUtils.isBlank(emptyString)).isTrue();
        assertThat(StringUtils.isBlank(nullString)).isTrue();
        assertThat(StringUtils.isBlank(blankString)).isTrue();
    }

    class PersonData{
        private String name;
        private int age;
        public PersonData(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void TEST_COMMONS_LANG3_HASHCODE_EQUALS(){
        PersonData p1 = new PersonData("김무스", 11);
        PersonData p2 = new PersonData("김무스", 11);

        int p1HashCode = HashCodeBuilder.reflectionHashCode(p1);
        int p2HashCode = HashCodeBuilder.reflectionHashCode(p2);

        // 1) hashcode
        assertThat(p1HashCode).isEqualTo(p2HashCode);
        // 2) equals
        assertThat(EqualsBuilder.reflectionEquals(p1, p2)).isTrue();
    }

    class Fruit{
        private String name;
        private BigDecimal price;

        public Fruit(String name, BigDecimal price){
            this.name = name;
            this.price = price;
        }

        public Fruit(Fruit other) throws InvocationTargetException, IllegalAccessException {
            BeanUtils.copyProperties(this, other);
        }
    }

    @Test
    public void TEST_COMMONS_LANG3_BEAN_UTILS() throws InvocationTargetException, IllegalAccessException {
        Fruit apple1 = new Fruit("사과", BigDecimal.valueOf(1000));
        Fruit apple2 = new Fruit(apple1);

        assertThat(EqualsBuilder.reflectionEquals(apple1, apple2)).isTrue();
    }

}
