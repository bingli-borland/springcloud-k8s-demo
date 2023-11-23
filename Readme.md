## Springcloud 整合 k8s 示例程序

文章目录：  

[Kubernetes 部署 SpringCloud应用（一）](https://blog.jisuye.com/2020/08/20/springcloud-k8s-demo1/)

docker build -t demo-data-bes:2.0 .

docker build -t demo-request-bes:2.0 .

docker save -o demo-data-bes-1.0.tar  demo-data-bes:2.0

docker save -o demo-request-bes-1.0.tar  demo-request-bes:2.0

scp demo-*.tar root@10.0.0.18:/root/

docker load < demo-data-bes-1.0.tar

docker load < demo-request-bes-1.0.tar

