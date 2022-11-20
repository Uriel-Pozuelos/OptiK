class iconPerson extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-person-fill">
    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
  </svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
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

customElements.define('icon-person', iconPerson);

class iconLock extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M15.8 8H14V5.6C14 2.703 12.665 1 10 1 7.334 1 6 2.703 6 5.6V8H4c-.553 0-1 .646-1 1.199V17c0 .549.428 1.139.951 1.307l1.197.387A7.731 7.731 0 0 0 7.1 19h5.8a7.68 7.68 0 0 0 1.951-.307l1.196-.387c.524-.167.953-.757.953-1.306V9.199C17 8.646 16.352 8 15.8 8zM12 8H8V5.199C8 3.754 8.797 3 10 3s2 .754 2 2.199V8z"/></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
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

customElements.define('icon-lock', iconLock);

class iconHome extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
        <svg width="20px" height="20px" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M18.672 11H17v6c0 .445-.194 1-1 1h-4v-6H8v6H4c-.806 0-1-.555-1-1v-6H1.328c-.598 0-.47-.324-.06-.748L9.292 2.22c.195-.202.451-.302.708-.312.257.01.513.109.708.312l8.023 8.031c.411.425.539.749-.059.749z"/></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
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

customElements.define('icon-home', iconHome);

class iconEye extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-eye"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path><circle cx="12" cy="12" r="3"></circle></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
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

customElements.define('icon-eye', iconEye);

class iconUpdate extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
    <path fill="none" stroke="currentColor" stroke-width="2" d="M1.7507,16.0022 C3.3517,20.0982 7.3367,23.0002 11.9997,23.0002 C18.0747,23.0002 22.9997,18.0752 22.9997,12.0002 M22.2497,7.9982 C20.6487,3.9012 16.6627,1.0002 11.9997,1.0002 C5.9247,1.0002 0.9997,5.9252 0.9997,12.0002 M8.9997,16.0002 L0.9997,16.0002 L0.9997,24.0002 M22.9997,0.0002 L22.9997,8.0002 L14.9997,8.0002"/>
  </svg>
  
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
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

customElements.define('icon-update', iconUpdate);
