"use strict"

let models = {

	infoColl : {
		"id" : "(integer)",
		"date" : "(string)",
		"centreDeFormation" : {
			"numeroVoie" : "(integer)",
			"adresse" : "(string)",
			"complementAdresse" : "(string)",
			"cp" : "(integer)",
			"ville" : "(string)",
			"telephone" : "(integer)",
			"coordonneeX" : "(integer)",
			"coordonneeY" : "(integer)"
		},
		"nombrePlacesMax" : "(integer)",
		"complet" : "(boolean)"
	},

	candidat : {
		"id" : "(integer)",		
		"prenom" : "(string)",
		"nom" : "(string)",
		"email" : "(string)",
		"mdp"   : "(string)",
		"numero" : "(integer)",
		"voie" : "(string)",
		"complement" : "(string)",
		"cp" : "(string)",
		"ville" : "(string)",
		"ddn" : "(integer)",
		"telephone" : "(string)",
		"numeroPe" : "(string)",
		"documents" : [
			{
				"id" : "(integer)",
				"chemin" : "(string)",
				"etat" : "(boolean | null)",
				"idType" : "(integer)"
			},
			{
				"id" : "(integer)",
				"chemin" : "(string)",
				"etat" : "(boolean | null)",
				"idType" : "(integer)"
			},
			{
				"id" : "(integer)",
				"chemin" : "(string)",
				"etat" : "(boolean | null)",
				"idType" : "(integer)"
			},
			{
				"id" : "(integer)",
				"chemin" : "(string)",
				"etat" : "(boolean | null)",
				"idType" : "(integer)"					
			}
		],
		"dev" : "(boolean)",
		"reseau" : "(boolean)",
		"admin" : "(boolean)",
		"infoCollective" : {
			"id" : "(integer)",
			"date" : "(string)",
			"centreDeFormation" : {
				"numeroVoie" : "(integer)",
				"adresse" : "(string)",
				"complementAdresse" : "(string)",
				"cp" : "(integer)",
				"ville" : "(string)",
				"telephone" : "(integer)",
				"coordonneeX" : "(integer)",
				"coordonneeY" : "(integer)"
				
			}
		},
		"idSessionConnexion" : "(integer)",
		"avancementInscription" : "(integer)"
	},

	formation : {
		"id" : "(integer)",
		"intitutle" : "(string)",
		"filiere" : "(integer)",
		"urlPhoto" : "(string)",
		"html" : "(string)"
		}, 

	faq : {
		"id" : "(integer)",
		"question" : "(string)",
		"reponse" : "(string)"
	},

	document : {
		"id" : "(integer)",
		"chemin" : "(string)",
		"etat" : "(boolean | null)",
		"idUser" : "(integer)",
		"type" : "(integer)"
	},

	donneesStatiques : {
		processusInscription : {
			"salarie_html" : "(string)",
			"demandeurEmploi_html" : "(string)",
			"telephone" : "(string)",
			"email" : "(string)"
		},
		formations : [
			{
			"id" : "(integer)",
			"intitutle" : "(string)",
			"filiere" : "(integer)",
			"urlPhoto" : "(string)",
			"html" : "(string)"
			},
			{
			"id" : "(integer)",
			"intitutle" : "(string)",
			"filiere" : "(integer)",
			"urlPhoto" : "(string)",
			"html" : "(string)"
			},
			{
			"id" : "(integer)",
			"intitutle" : "(string)",
			"filiere" : "(integer)",
			"urlPhoto" : "(string)",
			"html" : "(string)"
			},
			{
			"id" : "(integer)",
			"intitutle" : "(string)",
			"filiere" : "(integer)",
			"urlPhoto" : "(string)",
			"html" : "(string)"
			}
		],
		adrar_html : "(string)",
		infosCollectives_html : "(string)",
		listeInfosCollectives : 
			[
				{
				"id" : "(integer)",
				"date" : "(string)",
				"centreDeFormation" : {
					"id" : "(integer)",
					"numeroVoie" : "(integer)",
					"adresse" : "(string)",
					"complementAdresse" : "(string)",
					"cp" : "(integer)",
					"ville" : "(string)",
					"telephone" : "(integer)",
					"coordonneeX" : "(integer)",
					"coordonneeY" : "(integer)"
				},
				"nombrePlacesMax" : "(integer)",
				"complet" : "(boolean)"			
				},
				{
				"id" : "(integer)",
				"date" : "(string)",
				"centreDeFormation" : {
					"id" : "(integer)",
					"numeroVoie" : "(integer)",
					"adresse" : "(string)",
					"complementAdresse" : "(string)",
					"cp" : "(integer)",
					"ville" : "(string)",
					"telephone" : "(integer)",
					"coordonneeX" : "(integer)",
					"coordonneeY" : "(integer)"
				},
				"nombrePlacesMax" : "(integer)",
				"complet" : "(boolean)"			
				}
		],
		listeFaq : [
			{
				"id" : "(integer)",
				"question" : "(string)",
				"reponse" : "(string)"
			},
			{
				"id" : "(integer)",
				"question" : "(string)",
				"reponse" : "(string)"
			},
			{
				"id" : "(integer)",
				"question" : "(string)",
				"reponse" : "(string)"
			},
			{
				"id" : "(integer)",
				"question" : "(string)",
				"reponse" : "(string)"
			},{
				"id" : "(integer)",
				"question" : "(string)",
				"reponse" : "(string)"
			}
		]
	},
	erreur : {
		code : "(integer)",
		desc : "(string)"
	}

	
}

let entrees = {

	signin : {
		"prenom" : "(string)",
		"nom" : "(string)",
		"email" : "(string)",
		"mdp"   : "(string)"
	},

	detailsCandidat : {
		"prenom" : "(string)",
		"nom" : "(string)",
		"email" : "(string)",
		"mdp"   : "(string)",

		"numeroVoie" : "(integer | null)",
		"adresse" : "(string | null)",
		"complementAdresse" : "(string | null)",
		"cp" : "(integer | null)",
		"ville" : "(string | null)",
		"ddn" : "(integer | null)",
		"telephone" : "(integer | null)",

		"numeroPe" : "(string | null)",
		"dev" : "(boolean | null)",
		"reseau" : "(boolean | null)",
		"admin" : "(boolean)",
		"idInfoCollective" : "(string | null)",
		"idConnexionSession" : "(int)"
	},

	login : {
		"email" : "(string)",
		"mdp"   : "(string)"
	},

	envoiDocuments : [
		{
			"id_users" : "(integer)",
			"etat" : "(integer)",
			"id_tupeDocuments" : "(integer)",
			"base64" : "(string long)"
		},
		{
			"id_users" : "(integer)",
			"etat" : "(integer)",
			"id_tupeDocuments" : "(integer)",
			"base64" : "(string long)"
		},
		{
			"id_users" : "(integer)",
			"etat" : "(integer)",
			"id_tupeDocuments" : "(integer)",
			"base64" : "(string long)"
		},
		{
			"id_users" : "(integer)",
			"etat" : "(integer)",
			"id_tupeDocuments" : "(integer)",
			"base64" : "(string long)"
		}
	],

	inscriptionSessionCol : 
	{
		"ID_InfoCollective" : "(integer)"			
	},
	changementSessionCol : 
	{
		"ID_InfoCollective" : "(integer)"			
	}

}

function redableJson(obj, target, lastChild){
	//Dans le cas de la rédaction d'une documentation par exemple, il peut arriver que redableJson soit utilisé en passant 
	//en parametre un élément qui ne soit pas un objet. La vérification est nécéssaire.
	if (typeof obj === "object") {
		let bracket = {}
		Array.isArray(obj) ? bracket.open = "[" : bracket.open = "{"
		Array.isArray(obj) ? bracket.close = "]" : bracket.close = "}"
		let objetJson = document.createElement("div") //Élément html principal du JSON affiché sur la page
		objetJson.classList.add('indent', 'objet-Json', 'hide') //ajoute padding-left : 3rem à la propriété style de l'élément
		objetJson.innerHTML += `<span class="arrow"></span><span>${bracket.open}</span><span class="reduceObj">...${bracket.close}</span>` //accolade d'ouverture de l'objet
		let objetKeys = Object.keys(obj) //retourne un tableau des clés (clé/valeur) de l'objet -- Généralement des chaînes de caractères
		let objetValues = Object.values(obj); //retourne un tableau des valeurs (clé/valeur) de l'objet -- Différents type possibles, souvent des string, integer, array ou object
		for(let i = 0; i < objetValues.length; i++){ //objetValues et objetKeys font la même taille (une clé pour une valeur)
			if (typeof objetValues[i] === "object") {
				let clef = ""
				Array.isArray(obj) ? clef = "" : clef = '"'+objetKeys[i]+'" :'
				objetJson.innerHTML += `<p class='accordeon'><b>${clef}</b>  ` //Ajoute un paragraphe contenant la chaine de caractères clé[i] (en gras) dans l'objet Json principal (let objetJSON)
				
				//Si la valeur est un objet, nous devons l'itérer pour afficher ses clés et valeurs
				//Celà tombe bien, redableJson est fait pour ca
				//Pour afficher la valeur nous faisons une récursion
					//le paramètre obj reçoit l'objet valeur à itérer
					//le paramètre target recoit l'objet Json principal (nous voulons ajouter le HTML à la suite de la ligne précédente)
					//Le paramètre lastChild reçoit false si l'ensemle clé/valeur itéré n'est pas le dernier du tableau (il sera alors suivi d'une virgule)
					//et recoit true si c'est le dernier. (il n'y aura pas de virgule après)
				i != objetValues.length-1 ? redableJson(objetValues[i], objetJson) : redableJson(objetValues[i], objetJson, true)

			}
			else{
				//Si la valeur n'est pas un objet, pas besoin de l'itérer, nous pouvons l'afficher directement
				//Ici nous vérifions si l'ensemble clé/valeur est le dernier à afficher
				//Si c'est le cas, la variable coma sera une chaine de caractèeres vide, sinon elle contiendra une virgule
				let coma = ""
				i != objetValues.length-1 ? coma = ',' : coma = ""
				objetJson.innerHTML += `<p><b>"${objetKeys[i]}"</b> : ${objetValues[i]}${coma}</p>` //Affiche l'ensemble clé/valeur suivi du contenu de let coma
			}
		}
		//Ici nous fermons l'objet et le faisons suivre d'une virgule si d'autres objets sont à afficher derrière.
		lastChild ? objetJson.innerHTML += `<span>${bracket.close}</span>` : objetJson.innerHTML += `<span>${bracket.close},</span>`  
		target.appendChild(objetJson) //Intégre l'objet JSON final dans le DOM dans l'élément passé en argument au paramètre target	
	}		
}

//********************************************************************************************************************************************************************************//

function displayModels(){
	//recuperer les elements de classe model
	let eltHTMLcollection = document.querySelectorAll('.model')

	for (var i = 0; i < eltHTMLcollection.length; i++) {
		let wsName = eltHTMLcollection[i].id
		let wsObject = models[wsName]
		let target = eltHTMLcollection[i].querySelector('div')

		redableJson(wsObject, target, true)
	}
}

displayModels()


function displayEntryPostMethod(){

	//recuperer les elements de classe ws
	let eltHTMLcollection = document.querySelectorAll('.ws')
	for (var i = 0; i < eltHTMLcollection.length; i++) {
		//pour chacun, recuperer la classe autre que ws 
		let entryName = eltHTMLcollection[i].className.split(" ")[1]
		console.log(entryName + "\n")
		//recuperer le json a afficher
		let inObject = entrees[entryName]
		//recuperer la cible qui contiendra le json a afficher
		let target = eltHTMLcollection[i].querySelector('.entree')
		//afficher
		redableJson(inObject, target, true)
	}
}

displayEntryPostMethod()

function collapseObj(eltObj, arrow, bracket){
	eltObj.classList.toggle('hide')
	arrow.classList.toggle("up")
	bracket.classList.toggle("collapsed")
}

//*******************************************************************************************************************//

function setEventClickListennerOnAnchorLinks(){
	let links = document.querySelectorAll('a')

	for (var i = 0; i < links.length; i++) {
		links[i].addEventListener("click", (e)=>{
			let href = e.target.getAttribute('href')
			//recuperer l'element a derouler
			let collapsedElt = document.querySelector(`${href} .indent`)
			//recuperer l'accolade ou crochet de fin
			let bracket = document.querySelector(`${href} .reduceObj`)
			//recuperer la fleche
			let arrow = document.querySelector(`${href} .arrow`)

			collapseObj(collapsedElt, arrow, bracket)
		})
	}
}

setEventClickListennerOnAnchorLinks()

//*******************************************************************************************************************//
//Gestion de l'effet accordéon
function setEventClickListennerOnArrows(){
	
	let accordeons = document.querySelectorAll('.indent')
	accordeons.forEach((el)=>{
		let arrow = el.querySelector(".arrow")
		let reduce = el.querySelector(".reduceObj")
		arrow.addEventListener("click", (event)=>{
			event.stopPropagation()

			collapseObj(el, arrow, reduce)
		})
	})
}

setEventClickListennerOnArrows()