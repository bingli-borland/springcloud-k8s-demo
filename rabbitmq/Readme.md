# (1) 添加用户
rabbitmqctl add_user libing 123456
# （2）rabbitmq 修改密码
rabbitmqctl change_password libing 123456
# (3) 设置admin权限
rabbitmqctl set_user_tags libing administrator
# （4）rabbitmq 开启网页控制台
cd /opt/bitnami/rabbitmq/sbin/
rabbitmq-plugins list

http://rabbitmq.bingli.com:18080
http://rabbitmq.metrics.com:18080/metrics
