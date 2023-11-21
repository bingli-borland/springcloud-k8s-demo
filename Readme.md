## Springcloud 整合 k8s 示例程序

文章目录：  

[Kubernetes 部署 SpringCloud应用（一）](https://blog.jisuye.com/2020/08/20/springcloud-k8s-demo1/)

docker build -t demo-data:1.0 .

docker build -t demo-request:1.0 .

docker save -o demo-data-1.0.tar  demo-data:1.0

docker save -o demo-request-1.0.tar  demo-request:1.0

scp demo-*.tar root@10.0.0.18:/root/

docker load < demo-data-1.0.tar

docker load < demo-request-1.0.tar

