package io.study.gosgjung.spocksample.parallel

import spock.lang.Specification

class Test3 extends Specification{
    def "공부하기 -_- (5s)"(){
        given:
        def price = 1000

        when:
        def priceSum= 1000 * 2
        sleep(5000)

        then:
        priceSum == 2000
        0 * _
    }
}
