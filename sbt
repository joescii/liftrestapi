java -Drebel.lift_plugin=true -noverify -javaagent:/Users/kaiyin/opt/jrebel/jrebel.jar -Xmx1024M -Xss2M -XX:MaxPermSize=512m -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launch-0.13.1.jar "$@"
