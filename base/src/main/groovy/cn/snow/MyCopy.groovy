

/**
 * Created by Administrator on 07/16/2015.
 */
def baseDir = "D:"
//new File(baseDir, 'java技术.txt').eachLine { line ->
//    println line
//}

new File(baseDir, 'java技术.txt').eachLine { line, nb ->
    println "Line $nb: $line"
}