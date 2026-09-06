select * from java_venda;

select v.nome, vd.total, vd.data 
from java_vendedor v 
inner join java_venda vd 
on v.id = vd.id_vendedor;

