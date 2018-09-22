# spring-boot-example
关于创建仓库
关于bug
$ git push -u origin master 
To git@github.com:fansining/vueBox.git 
! [rejected] master -> master (fetch first) 
error: failed to push some refs to 'git@github.com:fansining/vueBox.git' 
hint: Updates were rejected because the remote contains work that you do 
hint: not have locally. This is usually caused by another repository pushing 
hint: to the same ref. You may want to first integrate the remote changes 
hint: (e.g., 'git pull ...') before pushing again. 
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

看见这个输入命令 $ git push origin master -f

---------------------

本文来自 microcosm1994 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/qq_39081974/article/details/78590907?utm_source=copy 

使用webjars 加载静态资源
``<link href="/css/bootstrap.min.css" rel="stylesheet">
  <link th:href="@{/webjars/bootstrap/4.1.3/css/bootstrap.css}" rel="stylesheet">``