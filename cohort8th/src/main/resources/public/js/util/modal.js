export default class Modal{
	constructor(){
		this.dlg = null;
		this.onok = null;
	}
	alert(message,title="알림"){
		
		this.dlg = document.createElement("div");
		this.dlg.className = "screen";
		let style = `
			.screen{
				position: fixed;
				left:0;
				top:0;
				
				width:100vw;
				height: 100vh;
				z-index: 1300;
				background-color: #000000a0;
				
				display: flex;
				align-items: center;
				justify-content: center;
			}
			
			
			.content-panel{
				background-color: #fff;
				min-width:200px;
				min-height: 100px;
				border-radius: 10px;
				
				
				/*position: relative;
				top: -100px;*/
				
				transform: translateY(-100px);
			
			}
				.content-panel>*{
					padding: 5px 10px;
				}
				
				.content-title{
					border-bottom: 1px solid #979797;	
				}
				
				.content-view{
					border-bottom: 1px solid #979797;
				}
				.content-command{
					
					display: flex;
					justify-content: center;
				}`;
				
		let template = `

			<div class="content-panel">
				<div class="content-title">제목</div>
				<div class="content-view">
					asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasfdasdfafad
				</div>
				<div class="content-command">
					<button class="btn-ok">확인</button>
					<button class="btn-cancel">취소</button>
				</div>
			</div>
			`;
		let styleEl = document.createElement("style"); 		
		styleEl.textContent = style;			
		this.dlg.innerHTML = template;
		
		document.head.appendChild(styleEl);
		document.body.appendChild(this.dlg);
		
		let btnOk = document.body.querySelector(".btn-ok");
		btnOk.onclick = ()=>{
			if(this.onok != null){
				this.onok();
				document.body.lastChild.remove();
			}
		};
		
	}
	confirm(message,title="선택"){
		
	}
	
	show(url){
		
	}
	
}

