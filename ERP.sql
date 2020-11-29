create table employee(
emp_code number(4) constraint pk_employee primary key,
emp_name varchar2(20),
emp_gender char(1),
emp_rank varchar2(20),
emp_hiredate number(8),
dept_no number(2) constraint fk_dept_no references department(dept_no), 
password varchar2(20),
is_admin char(1)
);

create table department (
dept_no number(2) constraint pk_department primary key,
dept_name varchar2(20), constraint uk_dept_name unique(dept_name)
);

create table goods(
goods_code number(4) constraint pk_goods primary key,
goods_name varchar2(20),
constraint uk_goods_name unique(goods_name),
goods_price number(5),
constraint uk_goods_price unique(goods_price),
goods_stock number(3)
);

CREATE SEQUENCE transaction_increment START WITH 1 INCREMENT BY 1 MAXVALUE 999 CYCLE NOCACHE;

create table transaction (
transaction_no number(4) constraint pk_transaction primary key,
goods_code number(4) constraint fk_goods_code references goods,
quantity number(3),
trasaction_date number(8),
transaction_type char(1)
);

create table salary(
emp_code number(4) constraint fk_emp_code references employee,
salary_date number(8),
constraint pk_salary primary key(emp_code, salary_date),
dept_no constraint fk_dept_name_2 references department,
salary_amout number(8)
);

CREATE SEQUENCE purchase_increment START WITH 1 INCREMENT BY 1 MAXVALUE 999 CYCLE NOCACHE;

create table asset(
purchase_num number(3),
capital number(10),
purchase_date number(8),
goods_code number(4) constraint fk_goods_code_2 references goods,
goods_changed_price number(5),
purchase_amount number(3)
);

insert into department values(10, 'ACCOUNTING');
insert into department values(20, 'RESEARCH');
insert into department values(30, 'SALES');
insert into department values(40, 'OPERATIONS');

insert into goods values(1001, 'PEN', 1200, 300);
insert into goods values(1002, 'NOTEBOOK', 3000, 297);
insert into goods values(1003, 'STAPLER', 4500, 57);
insert into goods values(2001, 'CHAIR', 55000, 300);
insert into goods values(2002, 'DESK', 77000, 300);

insert into employee values(7839, 'KING', 'M', 'PRESIDENT', '19811117', 10, 'password', 'T');
insert into employee values(7566, 'JONES', 'M', 'MANAGER', '19810402', 20, 'password', 'T');
insert into employee values(7698, 'BLAKE', 'F', 'MANAGER', '19810501', 30, 'password', 'T');
insert into employee values(7782, 'CLARK', 'F', 'MANAGER', '19810609', 10, 'password', 'T');
insert into employee values(7788, 'SCOTT', 'M', 'ANALYST', '19870713', 20, 'password', 'F');
insert into employee values(7902, 'FORD', 'M', 'ANALYST', '19811203', 20, 'password', 'F');
insert into employee values(7499, 'ALLEN', 'F', 'SALESMAN', '19810220', 30, 'password', 'F');
insert into employee values(7521, 'WARD', 'F', 'SALESMAN', '19810222', 30, 'password', 'F');
insert into employee values(7654, 'MARTIN', 'M', 'SALESMAN', '19810928', 30, 'password', 'F');
insert into employee values(7844, 'TURNER', 'M', 'SALESMAN', '19810908', 30, 'password', 'F');
insert into employee values(7900, 'JAMES', 'M', 'CLERK', '19811203', 30, 'password', 'F');
insert into employee values(7934, 'MILLER', 'F', 'CLERK', '19820123', 10, 'password', 'F');
insert into employee values(7369, 'SMITH', 'M', 'CLERK', '19801217', 20, 'password', 'F');
insert into employee values(7876, 'ADAMS', 'M', 'CLERK', '19870713', 20, 'password', 'F');

insert into transaction values(transaction_increment.nextval, 1001, 327, 20201009, 'P');
insert into transaction values(transaction_increment.nextval, 2001, 200, 20201010, 'P');
insert into transaction values(transaction_increment.nextval, 1002, 60, 20201010, 'P');
insert into transaction values(transaction_increment.nextval, 2001, 153, 20201010, 'P');
insert into transaction values(transaction_increment.nextval, 2002, 314, 20201012, 'P');
insert into transaction values(transaction_increment.nextval, 2001, 52, 20201013, 'S');
insert into transaction values(transaction_increment.nextval, 1003, 60, 20201013, 'P');
insert into transaction values(transaction_increment.nextval, 1003, 3, 20201014, 'S');
insert into transaction values(transaction_increment.nextval, 1001, 19, 20201005, 'S');
insert into transaction values(transaction_increment.nextval, 2001, 1, 20201018, 'S');
insert into transaction values(transaction_increment.nextval, 1002, 3, 20201021, 'S');
insert into transaction values(transaction_increment.nextval, 1001, 3, 20201023, 'S');
insert into transaction values(transaction_increment.nextval, 2002, 14, 20201030, 'S');
insert into transaction values(transaction_increment.nextval, 1001, 5, 20201031, 'S');

insert into salary values(7839, 20201015, 10, 99990000);
insert into salary values(7566, 20201015, 20, 8880000);
insert into salary values(7698, 20201015, 30, 8770000);
insert into salary values(7782, 20201015, 10, 8660000);
insert into salary values(7788, 20201015, 20, 4590000);
insert into salary values(7902, 20201015, 20, 5230000);
insert into salary values(7499, 20201015, 30, 3840000);
insert into salary values(7521, 20201015, 30, 6280000);
insert into salary values(7654, 20201015, 30, 3240000);
insert into salary values(7844, 20201015, 30, 2880000);
insert into salary values(7900, 20201015, 30, 2940000);
insert into salary values(7934, 20201015, 10, 1980000);
insert into salary values(7369, 20201015, 20, 2370000);
insert into salary values(7876, 20201015, 20, 7650000);
