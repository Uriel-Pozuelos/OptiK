class qualite extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
      <span class="qua1">QUA</span><span class="lite1">lite</span>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
      <style>
      .qua1 {
        font-size: 24px;
        font-weight: bold;
        color: #385499;
      }
      .lite1 {
        font-size: 20px;
        font-weight: lighter;
      }
          </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('qualite-text', qualite);
