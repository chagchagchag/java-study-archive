package io.study.gosgjung.spocksample.parallel

import spock.lang.Specification

class Test1 extends Specification {

    def "설거지 (2s)"(){
        given:
        def price = 1000

        when:
        def priceSum= 1000 * 2
        sleep(2000)

        then:
        priceSum == 2000
        0 * _
    }

    def "빨래 (3s)"(){
        given:
        def price = 2000

        when:
        def priceSum = 2000*0.5
        sleep(3000)

        then:
        priceSum == 1000
        0 * _
    }

}
