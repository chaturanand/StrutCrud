CREATE TABLE `employee` (
  `emp_id` int(5) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL,
  `emp_email` varchar(60) DEFAULT NULL,
  `emp_dept` varchar(20) DEFAULT NULL,
  `emp_salary` int(10) DEFAULT '0',
  PRIMARY KEY (`emp_id`)
);