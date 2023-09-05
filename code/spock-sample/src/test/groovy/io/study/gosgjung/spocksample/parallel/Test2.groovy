package io.study.gosgjung.spocksample.parallel

import spock.lang.Specification

class Test2 extends Specification{

    def "식사 (2s)"(){
        given:
        def price = 1000

        when:
        def priceSum= 1000 * 2
        sleep(2000)

        then:
        priceSum == 2000
        0 * _
    }

}
