1. 完成`java-algs4.bash`和`javac-algs4.bash`两个脚本后需要执行增加权限操作。
```shell
chmod u+x javac-algs4.bash 
chmod u+x java-algs4.bash
```
2. 然后将两个脚本软链接到`/usr/local/bin`，执行如下命令：
```shell
ln -s /Users/kangjinghang/workspace/github/Algorithms4th/bin/java-algs4.bash java-algs4
ln -s /Users/kangjinghang/workspace/github/Algorithms4th/bin/javac-algs4.bash javac-algs4
```
3. 修改`.bash_profile`文件中jdk配置
```shell
export JAVA_8_191_HOME=`/usr/libexec/java_home -v 1.8.0_191`
export JAVA_8_261_HOME=`/usr/libexec/java_home -v 1.8.0_261`
export JAVA_11_HOME=`/usr/libexec/java_home -v 11`
export JAVA_18_HOME=`/usr/libexec/java_home -v 18`
## 这个是设置默认jdk
export JAVA_HOME=$JAVA_8_261_HOME
```
4. 修改`.zshrc`文件中配置
```shell
## 快速切换版本使用
alias jdk8_191='export JAVA_HOME=$JAVA_8_191_HOME'
alias jdk8_261='export JAVA_HOME=$JAVA_8_261_HOME'
alias jdk11='export JAVA_HOME=$JAVA_11_HOME'
alias jdk18='export JAVA_HOME=$JAVA_18_HOME'
```
5. 使用方式如下
```shell
➜  ~ jdk11
➜  ~ java -version
openjdk version "11.0.14.1" 2022-02-08
OpenJDK Runtime Environment Homebrew (build 11.0.14.1+0)
OpenJDK 64-Bit Server VM Homebrew (build 11.0.14.1+0, mixed mode)
➜  ~ jdk8_191
➜  ~ java -version
java version "1.8.0_191"
Java(TM) SE Runtime Environment (build 1.8.0_191-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)
```