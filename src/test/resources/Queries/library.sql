
 -- US_2
select count(*) as borrowedBooks from users u
     inner join book_borrow b
         on u.id = b.user_id where is_returned = 0;

 -- US_5
select bc.name,count(*) from book_borrow bb
   inner  join books b on bb.book_id = b.id
   inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;

-- US_1
select * from users;

select distinct id from users;



 -- US_3
 select name from book_categories;