

CREATE TABLE beancsv (
REGION VARCHAR(100),
COUNTRY VARCHAR(100),
ITEMTYPE VARCHAR(100),
SALESCHANNELS VARCHAR(100),
ORDERPRIORITY VARCHAR (100),
ORDERDATE VARCHAR(100),
ORDERID PRIMARY KEY INTEGER,
SHIPDATE VARCHAR(100),
UNITSSOLD FLOAT,
UNITPRICE FLOAT,
INITCOST FLOAT,
TOTALREVENUE FLOAT,
TOTALCOAST FLOAT,
TOTALPROFIT FLOAT
);

INSERT INTO beancsv (REGION, COUNTRY,ITEMTYPE,SALESCHANNELS,ORDERPRIORITY,ORDERDATE,ORDERID,
                     SHIPDATE,UNITSSOLD,UNITPRICE,UNITCOST,TOTALREVENUE,TOTALCOAST, TOTALPROFIT)
             VALUES ('Middle East and North Africa', 'Libya','Cosmetics','Offline','M','11/7/2011',
                     '85941302','2/8/2011','3018','154.06','90.93','464953.08','274426.74','190526.34');