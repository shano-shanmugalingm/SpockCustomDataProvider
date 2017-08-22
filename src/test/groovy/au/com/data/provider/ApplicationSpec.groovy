package au.com.data.provider

import au.com.groovy.data.util.CustomDataProvider
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class ApplicationSpec extends Specification {
    def setup(){

    }

    def cleanup(){

    }

    @Unroll
    def "test data provider, for #testName"() {
        when :
        def a = name
        def b = age

        then :
        a == name
        b == age

        where :
        [testName, name, age] << new CustomDataProvider()
    }
}
