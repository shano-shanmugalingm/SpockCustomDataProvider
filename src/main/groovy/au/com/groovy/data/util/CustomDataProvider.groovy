package au.com.groovy.data.util

import groovy.json.JsonSlurper

/**
 * Created by senthur on 22/08/17.
 */
class CustomDataProvider implements Iterable {

    private JsonSlurper jsonSlurper = new JsonSlurper()

    def jsonFiles = []
    File jsonFolder = new File("resources/main/Sample/")


    public CustomDataProvider() {
        jsonFolder.eachFile {file -> jsonFiles << file}
    }


    @Override
    Iterator iterator() {
        return new CustomDataIterator()
    }

    private class CustomDataIterator implements Iterator {

        private int counter = 0



        @Override
        boolean hasNext() {
           return jsonFiles.size() > counter ? true : false
        }

        @Override
        List next() {
            def data = jsonSlurper.parse(jsonFiles.get(counter++))
            return data.values() as List
        }



    }
}
