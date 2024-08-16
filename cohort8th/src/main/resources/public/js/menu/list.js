function menuListLoad(url){
	let menuListSection = document.querySelector(".menu-list-section");
	let menuList = menuListSection.querySelector(".menu-list");
	
	fetch(url)
	.then(response=>response.json())
	.then(list=>{
		console.log(list);
		// 방 비우고
		menuList.innerHTML = "";
		
		let mid = document.querySelector("#input-member-id").value;
		
		// 아이템 채우고
		for(let menu of list){
			let itemTemplate = `<section class="menu">
				<div>

					<a href="detail">
						<img src="/image/${menu.img}" alt="에스프레소" />
					</a>
				</div>
				<h1>${menu.korName}</h1>
				<h2>${menu.engName}</h2>
				<div>${menu.price}원</div>
				<div>
					<a href="detail?id=${menu.id}" 
						data-member-id="${mid}"
						data-menu-id="${menu.id}"
						class="icon icon-heart ${menu.like?'icon-heart-fill':''}"
					></a>
					<span>${menu.likeCount}</span>
				</div>
				<div>
					<a href="" class="icon icon-plus icon-lg">추가</a>
					<a href="" class="icon icon-cart icon-lg">장바구니</a>
				</div>
			</section>`;
			
			menuList.insertAdjacentHTML("beforeend", itemTemplate);
		};
	});			
}

window.addEventListener("load", function(e){
	let menuListSection = document.querySelector(".menu-list-section");
	let menuList = menuListSection.querySelector(".menu-list");
	
	let tabSection = document.querySelector(".tab-section");
	
	let searchSection = document.querySelector(".search-section");
	let searchInput = searchSection.querySelector("input[name=q]");
	let searchButton = searchSection.querySelector(".icon-search");
	
	menuList.onclick = function(e){
		
		let el = e.target;
		
		if(!el.classList.contains("icon-heart"))
			return;
			
		e.preventDefault();
				
		let {memberId,menuId} = el.dataset; // destructuring

		// Like 삭제		
		if(el.classList.contains("icon-heart-fill")){
			fetch(`/api/menulikes/${menuId}/members/${memberId}`,{
				method:"DELETE"
			})
			.then(response=>response.text())
			.then(value=>parseInt(value))
			.then(result=>{
				if(result == 1){
					el.classList.remove("icon-heart-fill");
										
					fetch(`/api/menulikes/count?mn=${menuId}`)
					.then(response=>response.text())
					.then(value=>parseInt(value))
					.then(count=>{
						el.nextElementSibling.innerText = count;
						console.log(`count is ${count}`);
					});
				}
			});
		}
		// Like 추가
		else {
			let data = `mb=${memberId}&mn=${menuId}`;
			// POST
			// /api/menulikes
			console.log(data);
			fetch("/api/menulikes",{
			    method: 'POST',
			    headers: {
			      'Content-Type': 'application/x-www-form-urlencoded'
			    },
			    body: new URLSearchParams(data)
			  })
			.then(response=>response.text())
			.then(value=>parseInt(value))
			.then(result=>{
				if(result == 1){
					el.classList.add("icon-heart-fill");
					
					fetch(`/api/menulikes/count?mn=${menuId}`)
					.then(response=>response.text())
					.then(value=>parseInt(value))
					.then(count=>{
						el.nextElementSibling.innerText = count;
						console.log(`count is ${count}`);
					});
	
				}
			});
			
			
		}
		
	}
	
	searchButton.onclick = (e)=>{
		e.preventDefault();
		let queryText = searchInput.value;
		console.log(queryText);
		
		//fetch(`http://localhost:8080/api/menus?q=${queryText}`)
		menuListLoad(`http://localhost:8080/api/menus?q=${queryText}`);
		
	};
	
	tabSection.onclick = function(e){
		e.preventDefault();				
		if(e.target.tagName !== 'A')
			return;
		
		//fetch(`http://localhost:8080/api/menus?c=${e.target.dataset.id}`)
		menuListLoad(`http://localhost:8080/api/menus?c=${e.target.dataset.id}`);
	}		
});